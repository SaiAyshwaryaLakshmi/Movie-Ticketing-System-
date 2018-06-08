package org.projects.ThaliaUtility;

import java.util.List;

import org.projects.Thalia.Report;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;
import org.projects.Thalia.Tickets;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExclusionStrategyForTickets implements ExclusionStrategy {

	String selection;

	public ExclusionStrategyForTickets(String selection) {
		this.selection = selection;
	}

	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {

		
		if (this.selection.equalsIgnoreCase("allSections"))
			return (f.getName().equals("seating"))||(f.getName().equals("seatingList"));
		else if (this.selection.equalsIgnoreCase("getShow"))
			return (f.getName().equals("sectionName"))||(f.getName().equals("seatingList")
					||(f.getName().equals("seatsSold"))
					||(f.getName().equals("seatsAvailable"))
					||(f.getName().equals("sectionRevenue"))
					||(f.getName().equals("totalAmount"))
					||(f.getName().equals("donatedTickets"))
					||(f.getName().equals("donatedAndUsedTickets"))
					||(f.getName().equals("donatedAndUsedValue")) 
					||(f.getName().equals("occupancy")));
		else if (this.selection.equalsIgnoreCase("getSectionID"))
			return (f.getName().equals("seatsSold"))
					||(f.getName().equals("seatsAvailable"))
					||(f.getName().equals("sectionRevenue"))
					||(f.getName().equals("totalAmount"))
					||(f.getName().equals("donatedTickets"))
					||(f.getName().equals("donatedAndUsedTickets"))
					||(f.getName().equals("donatedAndUsedValue")) 
					||(f.getName().equals("occupancy"));
		else if (this.selection.equalsIgnoreCase("getShowSection"))
			return  (f.getName().equals("seatsSold"))
					||(f.getName().equals("seatsAvailable"))
					||(f.getName().equals("sectionRevenue"))
					||(f.getName().equals("seatingList"));
		else if (this.selection.equalsIgnoreCase("getSpecificSection"))
			return  (f.getName().equals("seatsSold"))
					||(f.getName().equals("donatedTickets"))
					||(f.getName().equals("donatedAndUsedTickets"))
					||(f.getName().equals("donatedAndUsedValue")) 
					||(f.getName().equals("seatsAvailable"))
					||(f.getName().equals("occupancy"));
		else if (this.selection.equalsIgnoreCase("getSpecificOrder"))
			return (f.getName().equals("seatingList")
					||(f.getName().equals("sectionName"))
					||(f.getName().equals("seatsSold"))
					||(f.getName().equals("seatsAvailable"))
					||(f.getName().equals("sectionRevenue"))
					||(f.getName().equals("totalAmount"))
					||(f.getName().equals("donatedTickets"))
					||(f.getName().equals("donatedAndUsedTickets"))
					||(f.getName().equals("donatedAndUsedValue"))
					||((f.getDeclaringClass().equals(Tickets.class))&&(f.getName().equals("showInfo")))
					||((f.getDeclaringClass().equals(Tickets.class))&&(f.getName().equals("price"))) 
					||((f.getDeclaringClass().equals(Tickets.class))&&(f.getName().equals("wid")))
					||((f.getDeclaringClass().equals(Tickets.class))&&(f.getName().equals("patronInfo"))) 
					||((f.getDeclaringClass().equals(Tickets.class))&&(f.getName().equals("sid"))) 
					||(f.getName().equals("seating"))
					||(f.getName().equals("occupancy")));
		else if (this.selection.equalsIgnoreCase("getOrders")||(this.selection.equalsIgnoreCase("getSearchOrder")))
			return (f.getName().equals("tickets"));
		else if (this.selection.equalsIgnoreCase("allShow")||this.selection.equalsIgnoreCase("getSearchShows"))
			return (f.getName().equals("sectionInfoList")||f.getName().equals("startingSeatId")
					||f.getName().equals("status")||f.getName().equals("totalAmount")
					||f.getName().equals("seatsAvailable")||f.getName().equals("seatsSold") 
					||f.getName().equals("donatedTickets")||f.getName().equals("donatedAndUsedTickets")
					||f.getName().equals("donatedAndUsedValue")||f.getName().equals("occupancy"));
		else if (this.selection.equalsIgnoreCase("getReports"))
			return ((f.getDeclaringClass().equals(Report.class))&&(f.getName().equals("soldSeats"))
					||(f.getName().equals("totalSeats"))
					||(f.getName().equals("donatedTickets"))
					||(f.getName().equals("donatedAndUsedTickets"))
					||(f.getName().equals("donatedAndUsedValue"))
					||(f.getName().equals("overallRevenue")));
		else if (this.selection.equalsIgnoreCase("getReportsForSpecificShow"))
			return (f.getName().equals("startDate")
					||(f.getName().equals("endDate"))
					||(f.getName().equals("donatedTickets"))
					||(f.getName().equals("donatedAndUsedTickets"))
					||(f.getName().equals("donatedAndUsedValue"))
					||(f.getName().equals("overallOccupancy"))
					||((f.getDeclaringClass().equals(Shows.class))&&(f.getName().equals("totalAmount")))
					||((f.getDeclaringClass().equals(Shows.class))&&(f.getName().equals("occupancy")))
					||((f.getDeclaringClass().equals(Shows.class))&&(f.getName().equals("seatsSold")))
					||((f.getDeclaringClass().equals(Shows.class))&&(f.getName().equals("seatsAvailable")))
					||((f.getDeclaringClass().equals(SectionInfo.class))&&(f.getName().equals("seatingList"))));
					
	
		return false;
		
	}

}