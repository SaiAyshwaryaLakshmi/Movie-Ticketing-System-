package org.projects.Thalia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Order {

@SerializedName("oid")
@Expose
private String oid;
@SerializedName("sid")
@Expose
private String sid;
@SerializedName("wid")
@Expose
private String wid;
@SerializedName("show_info")
@Expose
private ShowInfo showInfo;
@SerializedName("date_ordered")
@Expose
private String dateOrdered;
@SerializedName("order_amount")
@Expose
private Long orderAmount;
@SerializedName("number_of_tickets")
@Expose
private Long numberOfTickets;
@SerializedName("patron_info")
@Expose
private PatronInfo patronInfo;
@SerializedName("seats")
@Expose
private List<Seat> seats = null;

/**
* No args constructor for use in serialization
* 
*/
public Order() {
}

/**
* 
* @param showInfo
* @param dateOrdered
* @param orderAmount
* @param wid
* @param patronInfo
* @param oid
* @param numberOfTickets
*/
public Order(String oid, String wid, ShowInfo showInfo, String dateOrdered, Long orderAmount, Long numberOfTickets, PatronInfo patronInfo) {
super();
this.oid = oid;
this.wid = wid;
this.showInfo = showInfo;
this.dateOrdered = dateOrdered;
this.orderAmount = orderAmount;
this.numberOfTickets = numberOfTickets;
this.patronInfo = patronInfo;
}

public String getOid() {
return oid;
}

public void setOid(String oid) {
this.oid = oid;
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

public String getDateOrdered() {
return dateOrdered;
}

public void setDateOrdered(String dateOrdered) {
this.dateOrdered = dateOrdered;
}

public Long getOrderAmount() {
return orderAmount;
}

public void setOrderAmount(Long orderAmount) {
this.orderAmount = orderAmount;
}

public Long getNumberOfTickets() {
return numberOfTickets;
}

public void setNumberOfTickets(Long numberOfTickets) {
this.numberOfTickets = numberOfTickets;
}

public PatronInfo getPatronInfo() {
return patronInfo;
}

public void setPatronInfo(PatronInfo patronInfo) {
this.patronInfo = patronInfo;
}

public List<Seat> getSeats() {
return seats;
}

public void setSeats(List<Seat> seats) {
this.seats = seats;
}

public void setSid(String sid) {
this.sid = sid;
}

public String getSid() {
return this.sid;
}
}

