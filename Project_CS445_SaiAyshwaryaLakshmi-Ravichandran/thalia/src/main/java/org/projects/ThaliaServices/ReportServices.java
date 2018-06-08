package org.projects.ThaliaServices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.projects.Thalia.Report;
import org.projects.Thalia.Shows;
import org.projects.ThaliaUtility.ExclusionStrategyForTickets;
import org.projects.ThaliaUtility.UtilityDataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/reports")
public class ReportServices {
 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReports() {
		
			Gson gson = new GsonBuilder().setPrettyPrinting()
					.setExclusionStrategies(new ExclusionStrategyForTickets("getReports")).setPrettyPrinting().create();
			String s = gson.toJson(new ArrayList(UtilityDataStore.reportsMap.values()));
			return Response.status(Response.Status.OK).entity(s).build();	
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecificReports(@PathParam("id") String mrid,@QueryParam("show") String wid,@QueryParam("start_date") String startDate, @QueryParam("end_date") String endDate) {
		if(null!=wid&&!wid.equalsIgnoreCase(""))
		{
			return getReportForSpecificShow(mrid, wid);
		}
		else
			if((null!=startDate&&!startDate.equalsIgnoreCase(""))&&(null!=endDate&&!endDate.equalsIgnoreCase("")))
			{
				return getReportForShowsInDateRange(mrid, startDate, endDate);
			}
			else
			{
				return getReportForAllShows(mrid);
			}
			
	}
	
	public Response getReportForAllShows(String mrid)
	{
		Report reportBase =UtilityDataStore.reportsMap.get(mrid);
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getReportsForAllShows")).setPrettyPrinting().create();
		Report report = new Report();
		report.setMrid(reportBase.getMrid());
		report.setName(reportBase.getName());
		report.setStartDate("");
		report.setEndDate("");
		report.setTotalShows((long) UtilityDataStore.showsMap.values().size());
		List<Shows> showsList = new ArrayList<>();
		for(Shows shows:UtilityDataStore.showsMap.values())
		{
			Shows showSpecific = new Shows(shows); 
			report.setDonatedAndUsedTickets(report.getDonatedAndUsedTickets()!=null?report.getDonatedAndUsedTickets():0+shows.getDonatedAndUsedTickets());
			report.setDonatedAndUsedValue(report.getDonatedAndUsedValue()!=null?report.getDonatedAndUsedValue():0+shows.getDonatedAndUsedTickets());
			report.setDonatedTickets(report.getDonatedTickets()!=null?report.getDonatedTickets():0+shows.getDonatedTickets());
			report.setSoldSeats(report.getSoldSeats()!=null?report.getSoldSeats():0+shows.getSeatsSold());
			report.setTotalSeats(report.getTotalSeats()!=null?report.getTotalSeats():0+shows.getSeatsAvailable());
			report.setOverallRevenue(report.getOverallRevenue()!=null?report.getOverallRevenue():0+shows.getTotalAmount());
			showsList.add(showSpecific);
		}
		report.setOverallOccupancy(
				new Float((float) ((report.getSoldSeats()!=null?report.getSoldSeats():0 * 100) / (report.getTotalSeats()!=null?report.getTotalSeats()
						:1)))
				.toString() + "%");
		report.setShows(showsList);
		String s = gson.toJson(report); 
		
	return Response.status(Response.Status.OK).entity(s).build();	
	}
	public Response getReportForSpecificShow(String mrid,String wid)
	{
		Report reportBase =UtilityDataStore.reportsMap.get(mrid);
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getReportsForSpecificShow")).setPrettyPrinting().create();
		Report report = new Report();
		report.setMrid(reportBase.getMrid());
		report.setName(reportBase.getName());
		report.setStartDate("");
		report.setEndDate("");
		report.setTotalShows((long) UtilityDataStore.showsMap.values().size());
		report.setDonatedAndUsedTickets((long) (0));
		report.setDonatedAndUsedValue((long)0);
		report.setDonatedTickets((long)0);
		report.setSoldSeats((long)0);
		report.setTotalSeats((long)0);
		report.setOverallRevenue((long)0);
		List<Shows> showsList = new ArrayList<>();
		Shows shows=UtilityDataStore.showsMap.get(wid);
		{
			Shows showSpecific = new Shows(shows);
			report.setDonatedAndUsedTickets(report.getDonatedAndUsedTickets()+shows.getDonatedAndUsedTickets());
			report.setDonatedAndUsedValue(report.getDonatedAndUsedValue()+shows.getDonatedAndUsedValue());
			report.setDonatedTickets(report.getDonatedTickets()+shows.getDonatedTickets());
			report.setSoldSeats(report.getSoldSeats()+shows.getSeatsSold());
			report.setTotalSeats(report.getTotalSeats()+shows.getSeatsAvailable());
			report.setOverallRevenue(report.getOverallRevenue()+shows.getTotalAmount());
			showsList.add(showSpecific);
		}
		report.setOverallOccupancy(
				new Float((float) ((report.getSoldSeats() * 100) / report.getTotalSeats()))
				.toString() + "%");
		report.setShows(showsList);
		String s = gson.toJson(report);
		s=s.replaceAll("seating_info", "sections");
		s=s.replaceAll("price", "section_price");
		return Response.status(Response.Status.OK).entity(s).build();	
	}
	public Response getReportForShowsInDateRange(String mrid,String startDate,String endDate)
	{
		Report reportBase =UtilityDataStore.reportsMap.get(mrid);
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getReportsForDateRange")).setPrettyPrinting().create();
		Report report = new Report();
		report.setMrid(reportBase.getMrid());
		report.setName(reportBase.getName());
		report.setStartDate("");
		report.setEndDate("");
		report.setTotalShows((long) UtilityDataStore.showsMap.values().size());
		report.setDonatedAndUsedTickets((long) (0));
		report.setDonatedAndUsedValue((long)0);
		report.setDonatedTickets((long)0);
		report.setSoldSeats((long)0);
		report.setTotalSeats((long)0);
		report.setOverallRevenue((long)0);
		List<Shows> showsList = new ArrayList<>();
		for(Shows shows:UtilityDataStore.showsMap.values())
		{
			try {
			SimpleDateFormat orderFormatter = new SimpleDateFormat("yyyy-mm-dd",Locale.ENGLISH);
			Date showDate = orderFormatter.parse(shows.getShowInfo().getDate());
			SimpleDateFormat filterDate = new SimpleDateFormat("yyyyMMdd");
			Date start = filterDate.parse(startDate);
			Date end = filterDate.parse(endDate);
			if (showDate.compareTo(start) >= 0 && showDate.compareTo(end) <= 0) {
				
			
			Shows showSpecific = new Shows(shows); 
			report.setDonatedAndUsedTickets(report.getDonatedAndUsedTickets()+shows.getDonatedAndUsedTickets());
			report.setDonatedAndUsedValue(report.getDonatedAndUsedValue()+shows.getDonatedAndUsedTickets());
			report.setDonatedTickets(report.getDonatedTickets()+shows.getDonatedTickets());
			report.setSoldSeats(report.getSoldSeats()+shows.getSeatsSold());
			report.setTotalSeats(report.getTotalSeats()+shows.getSeatsAvailable());
			report.setOverallRevenue(report.getOverallRevenue()+shows.getTotalAmount());
			showsList.add(showSpecific);
			}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		report.setOverallOccupancy(
				new Float((float) ((report.getSoldSeats()!=null?report.getSoldSeats():0 * 100) / (report.getTotalSeats()!=null&&report.getTotalSeats()!=0?report.getTotalSeats()
						:1)))
				.toString() + "%");
		report.setShows(showsList);
		String s = gson.toJson(report);
		return Response.status(Response.Status.OK).entity(s).build();	
	}
	@PostConstruct
	public void postConstruct() {
		UtilityDataStore.initializeReportsMap();
	}
}
