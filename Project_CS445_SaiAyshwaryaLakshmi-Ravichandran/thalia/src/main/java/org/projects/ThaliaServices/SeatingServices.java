package org.projects.ThaliaServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SeatingShows;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.Shows;
import org.projects.ThaliaUtility.ExclusionStrategyForTickets;
import org.projects.ThaliaUtility.UtilityDataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
 
@Path("/seating")
public class SeatingServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSections(@QueryParam("show") String wid, @QueryParam("section") String sid,
			@QueryParam("count") String count, @QueryParam("starting_seat_id") String startingSeatId) {

		if (null == wid || wid.equalsIgnoreCase("")) {
			return getAllSections();
		} else

			return getSeatsForSection(wid, sid, count, startingSeatId,-1);
	}

	private Response getSeatsForSection(String wid, String sid, String count, String startingSeatId, int skipRowCount) {
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyForTickets("getSpecificSection"))
				.setPrettyPrinting().create();
		String setStartId=null;
		if(skipRowCount!=-1)
		{
			setStartId=startingSeatId;
			startingSeatId=null;
		}
		int skipRows=skipRowCount;
		String s;
		Boolean seatAvailableFlag = false;
		Boolean seatFound = false;
		boolean stopSkipflag=false;
		if (UtilityDataStore.showsMap.containsKey(wid)) {
			Shows shows = new Shows(UtilityDataStore.showsMap.get(wid));

			List<SectionInfo> sectionInfoList = shows.getSectionInfo();
			List<SectionInfo> sectionInfoSpecificList = new ArrayList<>();
			List<Seating> seatingSpecificList = new ArrayList<>();
			List<Seat> seatSpecificList = new ArrayList<>();
			int counter = 1;
			for (SectionInfo sectionInfo : sectionInfoList) {
				stopSkipflag=false;
				skipRows=skipRowCount;
				if(skipRowCount ==-1)
				{
					skipRowCount =0; 
				}
				if (sectionInfo.getSid().equalsIgnoreCase(sid)) {
					for (Seating seating : sectionInfo.getSeating()) {
						
						
						if (null == startingSeatId || startingSeatId.equalsIgnoreCase("")) {
							if(skipRows>0)
							{
								skipRows--;
								continue;
							}
							if (seating.getSeats().size() >= new Integer(count)) {
								for (Seat seat : seating.getSeats()) {
									seatSpecificList.add(seat);
									if (counter == new Integer(count)) {
									    break;
									}
									counter++;
								}
								seating.setSeats(seatSpecificList);
								seatingSpecificList.add(seating);
								sectionInfo.setSeating(seatingSpecificList);
								sectionInfoSpecificList.add(sectionInfo);
								shows.setStartingSeatId(seatSpecificList.get(0).getCid());
								shows.setSectionInfo(sectionInfoSpecificList);
								shows.setStatus("ok");
								shows.setTotalAmount(new Integer(count) * sectionInfo.getPrice());
								seatAvailableFlag = true;
								break;
							}
						} else {
							
								
							
							counter = 0;
							if(stopSkipflag==false)
							{
							skipRowCount++;
							}
							for (Seat seat : seating.getSeats()) {
								if (!seat.getCid().equalsIgnoreCase(startingSeatId) && seatFound == false) {
									counter++;
								} else {
									int i = 1;
									
									if (seating.getSeats().size() - counter >= new Integer(count)) {
										seatFound = true;
										seatSpecificList.add(seat);
										if (i == new Integer(count)) {
											break;
										}
										i++;
									} else {
										stopSkipflag=true;
										break;
									}
								}
							}
							if (seatFound == true) {
								skipRowCount=-1;
								seating.setSeats(seatSpecificList);
								seatingSpecificList.add(seating);
								sectionInfo.setSeating(seatingSpecificList);
								sectionInfoSpecificList.add(sectionInfo);
								shows.setStartingSeatId(seatSpecificList.get(0).getCid());
								shows.setSectionInfo(sectionInfoSpecificList);
								shows.setStatus("ok");
								shows.setTotalAmount(new Integer(count) * sectionInfo.getPrice());
								seatAvailableFlag = true;
								break;
							}
						}
					}

					if (seatAvailableFlag == false
							&& !(null == startingSeatId || startingSeatId.equalsIgnoreCase(""))) {
						return getSeatsForSection(wid, sid, count, startingSeatId,skipRowCount);
					} else if (seatAvailableFlag == false) {
						skipRowCount=-1;
						shows.setSectionInfo(sectionInfoSpecificList);
						shows.setStartingSeatId(sectionInfo.getSeating().get(0).getSeats().get(0).getCid());
						shows.setStatus("Error: " + count + " contiguous seats not available");
						break;
					}
				}
			}
			if(setStartId!=null)
			{
				shows.setStartingSeatId(setStartId);
			}
			SeatingShows seatingShows = new SeatingShows(shows);
			if(seatAvailableFlag==false)
			{
				seatingShows.setSid(sid);
				seatingShows.setSectionName(UtilityDataStore.theatreSectionMap.get(sid).getSectionName());
			}
			s = gson.toJson(seatingShows);
		
		} else {
			s = "{\"Result\":\"Notfound\"}";
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	private Response getAllSections() {
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyForTickets("allSections"))
				.setPrettyPrinting().create();
		String s = gson.toJson(new ArrayList(UtilityDataStore.theatreSectionMap.values()));
		return Response.status(Response.Status.OK).entity(s).build();
	}
 
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificSection(@PathParam("id") String sid) {
		// calls the "Get All Lamps" use case
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String s;
		if (UtilityDataStore.theatreSectionMap.containsKey(sid)) {
			s = gson.toJson(UtilityDataStore.theatreSectionMap.get(sid));
		} else {
			s = "{\"Result\":\"Notfound\"}";
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	@PostConstruct
	public void postConstruct() {
		UtilityDataStore.initializeTheatreSection();
	}
}
