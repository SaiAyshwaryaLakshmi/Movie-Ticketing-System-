package org.projects.Thalia;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TheatreSeating {

@SerializedName("row")
@Expose
private String row;
@SerializedName("seats")
@Expose
private List<String> seats = null;

public TheatreSeating() {
}

/**
* 
* @param seats
* @param row
*/
public TheatreSeating(String row, List<String> seats) {
super();
this.row = row;
this.seats = seats;
}

public String getRow() {
return row;
}

public void setRow(String row) {
this.row = row;
}

public List<String> getSeats() {
return seats;
}

public void setSeats(List<String> seats) {
this.seats = seats;
}


}