package org.projects.Thalia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrdersReceipt {

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
@SerializedName("tickets")
@Expose
private List<String> tickets = null;

/**
* No args constructor for use in serialization
* 
*/
public OrdersReceipt() {
}

/**
* 
* @param showInfo
* @param dateOrdered
* @param orderAmount
* @param wid
* @param oid
* @param tickets
*/ 
public OrdersReceipt(String oid, String wid, ShowInfo showInfo, String dateOrdered, Long orderAmount, List<String> tickets) {
super();
this.oid = oid;
this.wid = wid;
this.showInfo = showInfo;
this.dateOrdered = dateOrdered;
this.orderAmount = orderAmount;
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

public List<String> getTickets() {
return tickets;
}

public void setTickets(List<String> tickets) {
this.tickets = tickets;
}


}