package org.projects.Thalia;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Shows {

@SerializedName("wid")
@Expose
private String wid;
@SerializedName("show_info")
@Expose
private ShowInfo showInfo;
@SerializedName("seating_info")
@Expose
private List<SectionInfo> sectionInfoList =null;
@SerializedName("starting_seat_id")
@Expose
private String startingSeatId;
@SerializedName("status")
@Expose
private String status;
@SerializedName("total_amount")
@Expose
private Long totalAmount;
@SerializedName("seats_available")
@Expose
private Long seatsAvailable;
@SerializedName("seats_sold")
@Expose
private Long seatsSold;
@SerializedName("donated_tickets")
@Expose
private Long donatedTickets;
@SerializedName("donated_and_used_tickets")
@Expose
private Long donatedAndUsedTickets;
@SerializedName("donated_and_used_value")
@Expose
private Long donatedAndUsedValue;
@SerializedName("occupancy")
@Expose
private String occupancy;
/**
* No args constructor for use in serialization
* 
*/ 

public Shows(Shows shows)
{
	this.wid=shows.wid;
	this.showInfo = new ShowInfo(shows.showInfo);
	this.sectionInfoList=new ArrayList<SectionInfo>();
	for(SectionInfo sectionInfo:shows.sectionInfoList)
	{
		SectionInfo sectionInfoNew = new SectionInfo(sectionInfo);
		this.sectionInfoList.add(sectionInfoNew);
	}
	this.status=shows.status;
	this.startingSeatId =shows.startingSeatId;
	this.totalAmount=shows.totalAmount;
	this.seatsAvailable=shows.seatsAvailable;
	this.seatsSold=shows.seatsSold;
	this.donatedTickets=shows.donatedTickets;
	this.donatedAndUsedTickets=shows.donatedAndUsedTickets;
	this.donatedAndUsedValue=shows.donatedAndUsedValue;
	this.occupancy=shows.occupancy;
}

public Shows() {
}

public Shows(String wid, ShowInfo showInfo, Long seatsAvailable, Long seatsSold, String occupancy) {
super();
this.wid = wid;
this.showInfo = showInfo;
this.seatsAvailable = seatsAvailable;
this.seatsSold = seatsSold;
this.occupancy = occupancy;
}

/**
* 
* @param showInfo
* @param sid
* @param price
* @param wid
* @param seating
* @param sectionName
*/
public Shows(String wid, ShowInfo showInfo, String sid, String sectionName, Long price,List<SectionInfo> sectionInfo) {
super();
this.wid = wid;
this.showInfo = showInfo;
this.sectionInfoList= sectionInfo;
}

/**
* 
* @param showInfo
* @param seatsSold
* @param donatedTickets
* @param seatsAvailable
* @param wid
* @param donatedAndUsedTickets
* @param donatedAndUsedValue
*/
public Shows(String wid, ShowInfo showInfo, Long seatsAvailable, Long seatsSold, Long donatedTickets, Long donatedAndUsedTickets, Long donatedAndUsedValue) {
super();
this.wid = wid;
this.showInfo = showInfo;
this.seatsAvailable = seatsAvailable;
this.seatsSold = seatsSold;
this.donatedTickets = donatedTickets;
this.donatedAndUsedTickets = donatedAndUsedTickets;
this.donatedAndUsedValue = donatedAndUsedValue;
}
public String getWid() {
return wid;
}

public void setWid(String wid) {
this.wid = wid;
}

public ShowInfo getShowInfo() {
return showInfo;
}

public void setShowInfo(ShowInfo showInfo) {
this.showInfo = showInfo;
}

public List<SectionInfo> getSectionInfo() {
	return sectionInfoList;
}

public void setSectionInfo(List<SectionInfo> sectionInfo) {
	this.sectionInfoList = sectionInfo;
}

public Long getSeatsAvailable() {
return seatsAvailable;
}

public void setSeatsAvailable(Long seatsAvailable) {
this.seatsAvailable = seatsAvailable;
}

public Long getSeatsSold() {
return seatsSold;
}

public void setSeatsSold(Long seatsSold) {
this.seatsSold = seatsSold;
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

public String getOccupancy() {
return occupancy;
}

public void setOccupancy(String occupancy) {
this.occupancy = occupancy;
}

public String getStartingSeatId() {
return startingSeatId;
}

public void setStartingSeatId(String startingSeatId) {
this.startingSeatId = startingSeatId;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Long getTotalAmount() {
return totalAmount;
}

public void setTotalAmount(Long totalAmount) {
this.totalAmount = totalAmount;
}
}