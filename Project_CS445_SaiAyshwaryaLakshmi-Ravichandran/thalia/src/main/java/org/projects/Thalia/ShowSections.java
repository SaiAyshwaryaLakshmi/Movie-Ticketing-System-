package org.projects.Thalia;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowSections {

@SerializedName("wid")
@Expose
private String wid;
@SerializedName("show_info")
@Expose
private ShowInfo showInfo;
@SerializedName("sid")
@Expose
private String sid;
@SerializedName("section_name")
@Expose
private String sectionName;
@SerializedName("price")
@Expose
private Integer price;
@SerializedName("seating")
@Expose
private List<Seating> seating = null;

public ShowSections(Shows shows)
{
	this.wid=shows.getWid();
	this.showInfo = new ShowInfo(shows.getShowInfo());
	List<SectionInfo> sectionInfoList=new ArrayList<SectionInfo>();
	this.seating = new ArrayList<Seating>();
	for(SectionInfo sectionInfo:shows.getSectionInfo())
	{
		SectionInfo sectionInfoNew = new SectionInfo(sectionInfo);
		sectionInfoList.add(sectionInfoNew);
	}
	if(sectionInfoList.size()>0)
		
	{
	for(Seating seating:sectionInfoList.get(0).getSeating())
	{
		Seating seatingNew = new Seating(seating);
		this.seating.add(seatingNew);
	
	}
	
	this.sid = sectionInfoList.get(0).getSid();
	this.sectionName=sectionInfoList.get(0).getSectionName();
	this.price = sectionInfoList.get(0).getPrice().intValue();
	}

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

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public List<Seating> getSeating() {
return seating;
}

public void setSeating(List<Seating> seating) {
this.seating = seating;
}

}