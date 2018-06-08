package org.projects.Thalia;

	import java.util.ArrayList;
import java.util.List;
	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	public class SeatingShows {

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
	@SerializedName("starting_seat_id")
	@Expose
	private String startingSeatId;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("total_amount")
	@Expose
	private Integer totalAmount;
	@SerializedName("seating")
	@Expose
	private List<Seating> seating = null;
	
	public SeatingShows(Shows shows)
	{
		this.wid=shows.getWid();
		this.showInfo = new ShowInfo(shows.getShowInfo());
		List<SectionInfo> sectionInfoList=new ArrayList<SectionInfo>();
		this.seating = new ArrayList<Seating>();
		this.startingSeatId = shows.getStartingSeatId();
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
		if(shows.getStartingSeatId()!=null&&shows.getStartingSeatId().equals(""))
		{
		if(seating.size()>0&&seating.get(0).getSeats().size()>0)
		{
		this.startingSeatId=seating.get(0).getSeats().get(0).getCid();
		}
		
		}
		
		this.sid = sectionInfoList.get(0).getSid();
		this.sectionName=sectionInfoList.get(0).getSectionName();
		}

		this.status=shows.getStatus();
		this.totalAmount=shows.getTotalAmount().intValue();
	
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

	public String getStartingSeatId() {
	return startingSeatId;
	}

	public void setStartingSeatId(String startingSeatId) {
	this.startingSeatId = startingSeatId;
	}

	public String getStatus() {
	return status;
	}

	public void setStatus(String status) {
	this.status = status;
	}

	public Integer getTotalAmount() {
	return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
	this.totalAmount = totalAmount;
	}

	public List<Seating> getSeating() {
	return seating;
	}

	public void setSeating(List<Seating> seating) {
	this.seating = seating;
	}

	}

