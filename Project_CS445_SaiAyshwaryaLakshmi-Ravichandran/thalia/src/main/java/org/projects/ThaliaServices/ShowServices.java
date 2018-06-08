package org.projects.ThaliaServices;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONML;
import org.json.JSONObject;
import org.projects.Thalia.Donations;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SeatingShows;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowSections;
import org.projects.Thalia.Shows;
import org.projects.Thalia.TheatreSeating;
import org.projects.Thalia.TheatreSection;
import org.projects.Thalia.Tickets;
import org.projects.ThaliaUtility.ExclusionStrategyForTickets;
import org.projects.ThaliaUtility.UtilityDataStore;
import org.projects.ThaliaUtility.UniqueIdGenerator;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

@Path("/shows")
public class ShowServices {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createShow(String json) {
		Gson gson = new Gson();
		Shows showsFromRequest = gson.fromJson(json, Shows.class);
		showsFromRequest.setWid(UniqueIdGenerator.getUniqueID().toString());
		List<SectionInfo> sectionInfoList = showsFromRequest.getSectionInfo();
		Integer seatCount = 0;
		if(null!=sectionInfoList&&sectionInfoList.size()>0)
		{
			for (SectionInfo info : sectionInfoList) {
				if(UtilityDataStore.theatreSectionMap.get(info.getSid())!=null) {
					TheatreSection theatreSection = UtilityDataStore.theatreSectionMap.get(info.getSid());
					info.setSectionName((theatreSection).getSectionName());
					info.setSeatsSold((long)0);
					info.setSectionRevenue((long)0);
					info.setSeatsAvailable((long)0);
					List<Seating> seatingList = new ArrayList<Seating>();
					Seating seating = new Seating();
					List<Seat> seatList;
					Seat seat;
					List<TheatreSeating> theatreSeatingList = UtilityDataStore.theatreSectionMap.get(info.getSid())
							.getSeating();
					for (TheatreSeating t : theatreSeatingList) {
						seatList = new ArrayList<Seat>();
						seating = new Seating();
						seating.setRow(t.getRow());
						for (String s : t.getSeats()) {
							seatCount++;
							seat = new Seat();
							seat.setCid(UniqueIdGenerator.getUniqueID().toString());
							seat.setSeat(s);
							seat.setStatus("available");
							seatList.add(seat);
						}
						info.setSeatsAvailable(info.getSeatsAvailable()+seatList.size());
						seating.setSeats(seatList);
						seatingList.add(seating);
					}
					info.setSeating(seatingList);
				}else {
					return Response.status(400).build();
				}
			}
		}
		showsFromRequest.setSectionInfo(sectionInfoList);
		showsFromRequest.setTotalAmount(new Long(0));
		showsFromRequest.setDonatedAndUsedTickets(new Long(0));
		showsFromRequest.setDonatedAndUsedValue(new Long(0));
		showsFromRequest.setDonatedTickets(new Long(0));
		showsFromRequest.setOccupancy("0 %");
		showsFromRequest.setSeatsSold(new Long(0));
		showsFromRequest.setSeatsAvailable(new Long(seatCount));
		UtilityDataStore.showsMap.put(showsFromRequest.getWid(), showsFromRequest);
		return Response.status(Response.Status.CREATED).entity("{\"wid\":" + "\"" + showsFromRequest.getWid() + "\"" + "}")
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllShows() {

		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyForTickets("allShow"))
				.setPrettyPrinting().create();
		String s = gson.toJson(new ArrayList(UtilityDataStore.showsMap.values()));
		return Response.status(Response.Status.OK).entity(s).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShow(@PathParam("id") String wid) {
		// calls the "Get All Lamps" use case
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyForTickets("getShow"))
				.setPrettyPrinting().create();
		String s;
		if (UtilityDataStore.showsMap.containsKey(wid)) {
			s = gson.toJson(UtilityDataStore.showsMap.get(wid));
		} else {
			s = "{\"Result\":\"Notfound\"}";
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateShow(@PathParam("id") String wid, String json) throws FileNotFoundException {
		Gson gson = new Gson();
		Shows showsFromRequest = gson.fromJson(json, Shows.class);
		List<SectionInfo> sectionInfoList = showsFromRequest.getSectionInfo();

		if (UtilityDataStore.showsMap.containsKey(wid)) {
			Shows updateShows = new Shows(UtilityDataStore.showsMap.get(wid));
			updateShows.setShowInfo(showsFromRequest.getShowInfo());
			for (SectionInfo sectionInfo : sectionInfoList) {
				for (SectionInfo sectionInfoSpecific : updateShows.getSectionInfo()) {
					if (sectionInfoSpecific.getSid().equalsIgnoreCase(sectionInfo.getSid())) {
						sectionInfoSpecific.setPrice(sectionInfo.getPrice());
						break;
					}
				}
			}
			UtilityDataStore.showsMap.put(wid, updateShows);
			/*JsonObject jsonObject = new JsonObject();*/
			String s = gson.toJson(UtilityDataStore.responseMap);
			/*String e = s.replace("{", "");
			String r = e.replace("}", "");*/
			return Response.status(Response.Status.OK).entity(s).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	@GET
	@Path("{id}/sections")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShowSection(@PathParam("id") String wid) {
		// calls the "Get All Lamps" use case
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyForTickets("getShowSection"))
				.setPrettyPrinting().create();
		String s;
		if (UtilityDataStore.showsMap.containsKey(wid)) {
			s = gson.toJson(UtilityDataStore.showsMap.get(wid).getSectionInfo());
		} else {
			s = "{\"Result\":\"Notfound\"}";
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	@POST
	@Path("{id}/donations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setDonations(@PathParam("id") String wid, String json) {

		Gson gson = new Gson();
		Donations donation = gson.fromJson(json, Donations.class);
		//Donations donation = new Donations();
		donation.setDid(UniqueIdGenerator.getUniqueID().toString());
		donation.setTickets(new ArrayList<String>());
		donation.setStatus("pending");
		UtilityDataStore.donationsMap.put(donation.getDid(), donation);
		String s = gson.toJson(donation.getDid());
		return Response.status(Response.Status.CREATED).entity("{\"did\":" + "\"" +donation.getDid()+"\"" + "}" ).build();
	}


	@GET
	@Path("{id}/donations/{did}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDonations(@PathParam("id") String wid, @PathParam("did") String did) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String s;
		List<String> ticketList = new ArrayList<String>();
		List<String> specificTicketList = new ArrayList<String>();
		for (String tk : UtilityDataStore.subscriptionList) {
			ticketList.add(tk);
		}
		if (UtilityDataStore.donationsMap.containsKey(did)) {
			Donations donation = UtilityDataStore.donationsMap.get(did);
			if (donation.getStatus().equalsIgnoreCase("pending")) {
				if (ticketList.size() > 0) {
					for (int i = 0; i < ticketList.size(); i++) {
						if (!(donation.getCount() == i)) {
							specificTicketList.add(ticketList.get(i));
							UpdateDonatedTicket(ticketList.get(i));
							UtilityDataStore.subscriptionList.remove(0);
						} else if ((donation.getCount() == i)) {
							break;
						}
					}
					donation.setStatus("assigned");
					donation.setTickets(specificTicketList);
				}
			}
			s = gson.toJson(UtilityDataStore.donationsMap.get(did));
		} else {
			s = "{\"Result\":\"Notfound\"}";
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	private void UpdateDonatedTicket(String ticket) {

		Shows shows = UtilityDataStore.showsMap.get(UtilityDataStore.ticketsMap.get(ticket).getWid());
		boolean isSeatFound = false;
		shows.setDonatedTickets(shows.getDonatedTickets() + 1);
		shows.setDonatedAndUsedTickets(shows.getDonatedAndUsedTickets() + 1);

		for (SectionInfo sectionInfo : shows.getSectionInfo()) {
			if (sectionInfo.getSid().equalsIgnoreCase(UtilityDataStore.ticketsMap.get(ticket).getSid())) {
				shows.setDonatedAndUsedValue(shows.getDonatedAndUsedValue() + sectionInfo.getPrice());
				break;
			}
		}

	}

	@GET
	@Path("{id}/sections/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShowSpecificSection(@PathParam("id") String wid, @PathParam("sid") String sid) {
		// calls the "Get All Lamps" use case
		Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategyForTickets("getSectionID"))
				.setPrettyPrinting().create();
		String s;
		if (UtilityDataStore.showsMap.containsKey(wid)) {
			Shows shows = new Shows(UtilityDataStore.showsMap.get(wid));

			List<SectionInfo> sectionInfoList = shows.getSectionInfo();
			List<SectionInfo> sectionInfoSpecificList = new ArrayList<>();
			for (SectionInfo sectionInfo : sectionInfoList) {
				if (sectionInfo.getSid().equalsIgnoreCase(sid)) {
					sectionInfoSpecificList.add(sectionInfo);
					shows.setSectionInfo(sectionInfoSpecificList);
					break;
				}
			}
			ShowSections show = new ShowSections(shows);
			s = gson.toJson(show);
		} else {
			s = "{\"Result\":\"Notfound\"}";
			return Response.status(Response.Status.NOT_FOUND).entity(s).build();
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	@PostConstruct
	public void postConstruct() {
		UtilityDataStore.initializeTheatreSection();
	}
}
