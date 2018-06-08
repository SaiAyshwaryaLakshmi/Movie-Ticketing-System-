package org.projects.Thalia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Seat {

@SerializedName("cid")
@Expose
private String cid;
@SerializedName("seat")
@Expose
private String seat;
@SerializedName("status")
@Expose
private String status;

/**
* No args constructor for use in serialization
* 
*/ 
public Seat() {
}
 
/**
* 
* @param status
* @param seat
* @param cid
*/
public Seat(String cid, String seat, String status) {
super();
this.cid = cid;
this.seat = seat;
this.status = status;
}

public Seat(Seat seat) {
	this.cid = seat.cid;
	this.seat = seat.seat;
	this.status = seat.status;	
}

public String getCid() {
return cid;
}

public void setCid(String cid) {
this.cid = cid;
}

public String getSeat() {
return seat;
}

public void setSeat(String seat) {
this.seat = seat;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}