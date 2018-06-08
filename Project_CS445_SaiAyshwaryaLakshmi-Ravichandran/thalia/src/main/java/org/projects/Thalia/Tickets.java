
package org.projects.Thalia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Tickets {

@SerializedName("tid")
@Expose
private String tid;
@SerializedName("price")
@Expose
private Long price;
@SerializedName("status")
@Expose
private String status;
@SerializedName("wid")
@Expose
private String wid;
@SerializedName("show_info")
@Expose
private ShowInfo showInfo;
@SerializedName("patron_info")
@Expose
private PatronInfo patronInfo;
@SerializedName("sid")
@Expose
private String sid;
@SerializedName("section_name")
@Expose
private String sectionName;
@SerializedName("seating")
@Expose
private List<Seating> seating = null;

/**
* No args constructor for use in serialization
* 
*/
public Tickets() {
}

/**
* 
* @param showInfo
* @param sid
* @param price
* @param wid
* @param status
* @param patronInfo
* @param seating
* @param sectionName
* @param tid
*/
public Tickets(String tid, Long price, String status, String wid, ShowInfo showInfo, PatronInfo patronInfo, String sid, String sectionName, List<Seating> seating) {
super();
this.tid = tid;
this.price = price;
this.status = status;
this.wid = wid;
this.showInfo = showInfo;
this.patronInfo = patronInfo;
this.sid = sid;
this.sectionName = sectionName;
this.seating = seating;
}

public String getTid() {
return tid;
}

public void setTid(String tid) {
this.tid = tid;
}

public Long getPrice() {
return price;
}

public void setPrice(Long price) {
this.price = price;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
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

public PatronInfo getPatronInfo() {
return patronInfo;
}

public void setPatronInfo(PatronInfo patronInfo) {
this.patronInfo = patronInfo;
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

public List<Seating> getSeating() {
return seating;
}

public void setSeating(List<Seating> seating) {
this.seating = seating;
}



}