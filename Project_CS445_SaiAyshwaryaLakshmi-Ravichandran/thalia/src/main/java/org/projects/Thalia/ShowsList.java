package org.projects.Thalia;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowsList {

	@SerializedName("wid")
	@Expose
	private List<Shows> shows;

	public ShowsList()
	{
		
	}
	
	public List<Shows> getShows() {
		return shows;
	}

	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}
}
