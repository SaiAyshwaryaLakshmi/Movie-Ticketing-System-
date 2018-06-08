package org.projects.Thalia;

import java.util.List;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeatingInfo {

@SerializedName("sid")
@Expose
private String sid;
@SerializedName("price")
@Expose
private Long price;

/**
* No args constructor for use in serialization
* 
*/
public SeatingInfo() {
}

/**
* 
* @param sid
* @param price
*/
public SeatingInfo(String sid, Long price) {
super();
this.sid = sid;
this.price = price;
}

public String getSid() {
return sid;
}

public void setSid(String sid) {
this.sid = sid;
}

public Long getPrice() {
return price;
}

public void setPrice(Long price) {
this.price = price;
}

}
