package org.projects.Thalia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrdersSectionReceipt {

@SerializedName("oid")
@Expose
private String oid;
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
@SerializedName("tickets")
@Expose
private List<Tickets> tickets = null;

/**
* No args constructor for use in serialization
* 
*/
public OrdersSectionReceipt() {
}

/**
* 
* @param showInfo
* @param dateOrdered
* @param orderAmount
* @param wid
* @param patronInfo
* @param oid
* @param tickets
* @param numberOfTickets
*/ 
public OrdersSectionReceipt(String oid, String wid, ShowInfo showInfo, String dateOrdered, Long orderAmount, Long numberOfTickets, PatronInfo patronInfo, List<Tickets> tickets) {
super();
this.oid = oid;
this.wid = wid;
this.showInfo = showInfo;
this.dateOrdered = dateOrdered;
this.orderAmount = orderAmount;
this.numberOfTickets = numberOfTickets;
this.patronInfo = patronInfo;
this.tickets = tickets;
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

public List<Tickets> getTickets() {
return tickets;
}

public void setTickets(List<Tickets> tickets) {
this.tickets = tickets;
}


}