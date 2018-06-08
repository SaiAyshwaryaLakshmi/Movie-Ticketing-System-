package org.projects.Thalia;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Seating {

@SerializedName("row")
@Expose
private String row;
@SerializedName("seats")
@Expose
private List<Seat> seats = null;
 
/**
* No args constructor for use in serialization
* 
*/ 
public Seating(Seating seating)
{
	this.seats = new ArrayList<Seat>();
	this.row=seating.row;
	for(Seat seat :seating.seats)
	{
		Seat seatNew = new Seat(seat);
		this.seats.add(seatNew);
	}
}
public Seating() {
}

/**
* 
* @param seats
* @param row
*/
public Seating(String row, List<Seat> seats) {
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

public List<Seat> getSeats() {
return seats;
}

public void setSeats(List<Seat> seats) {
this.seats = seats;
}



}