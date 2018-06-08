package org.projects.Thalia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TheatreSection {
@SerializedName("sid")
@Expose
private String sid;
@SerializedName("section_name")
@Expose
private String sectionName;
@SerializedName("seating")
@Expose
private List<TheatreSeating> seating = null;

/**
* No args constructor for use in serialization
* 
*/
public TheatreSection() {
}

/**
* 
* @param seating
* @param sectionName
*/
public TheatreSection(String sectionName, List<TheatreSeating> seating) {
super();
this.sectionName = sectionName;
this.seating = seating;
}

public String getSectionName() {
return sectionName;
}

public void setSectionName(String sectionName) {
this.sectionName = sectionName;
}

public List<TheatreSeating> getSeating() {
return seating;
}

public void setSeating(List<TheatreSeating> seating) {
this.seating = seating;
}

public void setSid(String sid) {
this.sid = sid;
}

public String getSid() {
return this.sid;
}

}