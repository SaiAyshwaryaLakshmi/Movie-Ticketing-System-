package org.projects.Thalia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Report {

@SerializedName("mrid")
@Expose
private String mrid;
@SerializedName("name")
@Expose
private String name;
@SerializedName("start_date")
@Expose
private String startDate;
@SerializedName("end_date")
@Expose
private String endDate;
@SerializedName("total_shows")
@Expose
private Long totalShows;
@SerializedName("total_seats")
@Expose
private Long totalSeats;
@SerializedName("sold_seats")
@Expose
private Long soldSeats;
@SerializedName("donated_tickets")
@Expose
private Long donatedTickets;
@SerializedName("donated_and_used_tickets")
@Expose
private Long donatedAndUsedTickets;
@SerializedName("donated_and_used_value")
@Expose
private Long donatedAndUsedValue;
@SerializedName("overall_occupancy")
@Expose
private String overallOccupancy;
@SerializedName("overall_revenue")
@Expose
private Long overallRevenue;
@SerializedName("shows")
@Expose
private List<Shows> shows = null;
/**
* No args constructor for use in serialization
* 
*/
public Report() {
}

/**
* 
* @param mrid
* @param name
*/
public Report(String mrid, String name) {
super();
this.mrid = mrid;
this.name = name;
}

public String getMrid() {
return mrid;
}

public void setMrid(String mrid) {
this.mrid = mrid;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public String getEndDate() {
	return endDate;
}

public void setEndDate(String endDate) {
	this.endDate = endDate;
}

public Long getTotalShows() {
	return totalShows;
}

public void setTotalShows(Long totalShows) {
	this.totalShows = totalShows;
}

public Long getTotalSeats() {
	return totalSeats;
}

public void setTotalSeats(Long totalSeats) {
	this.totalSeats = totalSeats;
}

public Long getSoldSeats() {
	return soldSeats;
}

public void setSoldSeats(Long soldSeats) {
	this.soldSeats = soldSeats;
}

public Long getDonatedTickets() {
	return donatedTickets;
}

public void setDonatedTickets(Long donatedTickets) {
	this.donatedTickets = donatedTickets;
}

public Long getDonatedAndUsedTickets() {
	return donatedAndUsedTickets;
}

public void setDonatedAndUsedTickets(Long donatedAndUsedTickets) {
	this.donatedAndUsedTickets = donatedAndUsedTickets;
}

public Long getDonatedAndUsedValue() {
	return donatedAndUsedValue;
}

public void setDonatedAndUsedValue(Long donatedAndUsedValue) {
	this.donatedAndUsedValue = donatedAndUsedValue;
}

public String getOverallOccupancy() {
	return overallOccupancy;
}

public void setOverallOccupancy(String overallOccupancy) {
	this.overallOccupancy = overallOccupancy;
}

public Long getOverallRevenue() {
	return overallRevenue;
}

public void setOverallRevenue(Long overallRevenue) {
	this.overallRevenue = overallRevenue;
}

public List<Shows> getShows() {
	return shows; 
}

public void setShows(List<Shows> shows) {
	this.shows = shows;
}

}

