package org.projects.Thalia;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowInfo {

@SerializedName("name")
@Expose
private String name;
@SerializedName("web")
@Expose
private String web;
@SerializedName("date")
@Expose
private String date;
@SerializedName("time")
@Expose
private String time;

/**
* No args constructor for use in serialization
*  
*/

public ShowInfo(ShowInfo showinfo)
{
	this.name=showinfo.name;
	this.web=showinfo.web;
	this.date=showinfo.date;
	this.time=showinfo.time;
}
public ShowInfo() {
}

/**
* 
* @param time
* @param name
* @param web
* @param date
*/
public ShowInfo(String name, String web, String date, String time) {
super();
this.name = name;
this.web = web;
this.date = date;
this.time = time;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getWeb() {
return web;
}

public void setWeb(String web) {
this.web = web;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getTime() {
return time;
}

public void setTime(String time) {
this.time = time;
}


}