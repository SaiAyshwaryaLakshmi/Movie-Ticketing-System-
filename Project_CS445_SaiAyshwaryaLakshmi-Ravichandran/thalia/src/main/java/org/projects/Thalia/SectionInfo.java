package org.projects.Thalia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SectionInfo {

@SerializedName("sid")
@Expose
private String sid;
@SerializedName("section_name")
@Expose
private String sectionName;
@SerializedName("price")
@Expose
private Long price;
@SerializedName("section_price")
@Expose
private Long sectionPrice;
@SerializedName("seats_available")
@Expose
private Long seatsAvailable;
@SerializedName("seats_sold")
@Expose
private Long seatsSold;
@SerializedName("section_revenue")
@Expose
private Long sectionRevenue;
@SerializedName("seating")
@Expose
private List<Seating> seatingList = null;
/**
* No args constructor for use in serialization
* 
*/

public SectionInfo(SectionInfo sectionInfo)
{
	this.sid=sectionInfo.sid;
	this.sectionName=sectionInfo.sectionName;
	this.price=sectionInfo.price;
	this.seatsAvailable=sectionInfo.seatsAvailable;
	this.seatsSold=sectionInfo.seatsSold;
	this.sectionRevenue=sectionInfo.sectionRevenue;
	this.seatingList=new ArrayList<Seating>();
	for(Seating seating:sectionInfo.getSeating())
	{
		Seating seatingNew = new Seating(seating);
		this.seatingList.add(seatingNew);
		
	}
}

public SectionInfo() {
}

/**
* 
* @param sid
* @param seatsSold
* @param seatsAvailable
* @param sectionRevenue
* @param sectionName
* @param sectionPrice
*/
public SectionInfo(String sid, String sectionName, Long sectionPrice, Long seatsAvailable, Long seatsSold, Long sectionRevenue) {
super();
this.sid = sid;
this.sectionName = sectionName;
this.sectionPrice = sectionPrice;
this.seatsAvailable = seatsAvailable;
this.seatsSold = seatsSold;
this.sectionRevenue = sectionRevenue;
}
/**
* 
* @param sid
* @param price
* @param sectionName
*/
public SectionInfo(String sid, String sectionName, Long price) {
super();
this.sid = sid;
this.sectionName = sectionName;
this.price = price;
}

public String getSid() {
return sid;
}

public void setSid(String sid) {
this.sid = sid;
}

public String getSectionName() {
return sectionName;
}

public void setSectionName(String sectionName) {
this.sectionName = sectionName;
}

public Long getPrice() {
return price;
}

public void setPrice(Long price) {
this.price = price;
}

public Long getSectionPrice() {
return sectionPrice;
}

public void setSectionPrice(Long sectionPrice) {
this.sectionPrice = sectionPrice;
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

public Long getSectionRevenue() {
return sectionRevenue;
}

public void setSectionRevenue(Long sectionRevenue) {
this.sectionRevenue = sectionRevenue;
}

public void setSeating(List<Seating> seatingList) {
this.seatingList = seatingList;
	
}

public List<Seating> getSeating() {
return this.seatingList;
	
}


}