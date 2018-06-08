
package org.projects.Thalia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Donations {

@SerializedName("did")
@Expose
private String did;
@SerializedName("wid")
@Expose
private String wid;
@SerializedName("count")
@Expose
private Long count;
@SerializedName("status")
@Expose
private String status;
@SerializedName("tickets")
@Expose
private List<String> tickets = null;
@SerializedName("patron_info")
@Expose
private PatronInfo patronInfo;

/**
* No args constructor for use in serialization
* 
*/
public Donations() {
}

/**
* 
* @param count
* @param status
* @param wid
* @param patronInfo
* @param did
* @param tickets
*/
public Donations(String did, String wid, Long count, String status, List<String> tickets, PatronInfo patronInfo) {
super();
this.did = did;
this.wid = wid;
this.count = count;
this.status = status;
this.tickets = tickets;
this.patronInfo = patronInfo;
}

public String getDid() {
return did;
}

public void setDid(String did) {
this.did = did;
}

public String getWid() {
return wid;
}

public void setWid(String wid) {
this.wid = wid;
}

public Long getCount() {
return count;
}

public void setCount(Long count) {
this.count = count;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public List<String> getTickets() {
return tickets;
}

public void setTickets(List<String> tickets) {
this.tickets = tickets;
}

public PatronInfo getPatronInfo() {
return patronInfo;
}

public void setPatronInfo(PatronInfo patronInfo) {
this.patronInfo = patronInfo;
}

}