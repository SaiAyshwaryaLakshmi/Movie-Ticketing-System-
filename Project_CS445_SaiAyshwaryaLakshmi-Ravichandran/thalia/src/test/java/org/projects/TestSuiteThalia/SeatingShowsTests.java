package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SeatingShows;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.ShowSections;
import org.projects.Thalia.Shows;

public class SeatingShowsTests {

	Seating seating1 = new Seating();
	List <Seat> seats = new ArrayList<>();
	List<Seat> seat2 = new ArrayList<>();
	
	List<SectionInfo> sectionInfo = new ArrayList<>();
	List <SectionInfo> newSectionInfo = new ArrayList<>();
	List<Seating> seating = new ArrayList<>();
	List<Seating> seatingList = new ArrayList<>();
	
	@Test
	public void test_gettersANDSetters()
	{
		Shows show = new Shows();
		  ShowInfo showInfo = new ShowInfo();
		  
		  show.setShowInfo(showInfo);
		show.setSectionInfo(sectionInfo);
		show.setTotalAmount(0L);
		SeatingShows s = new SeatingShows(show);
		
		showInfo.setName("Alex");
		showInfo.setTime("12:00");
		showInfo.setWeb("example.com");
		showInfo.setDate("12-01-2017");
		show.setWid("708");
		show.setDonatedAndUsedTickets(3L);
		show.setDonatedAndUsedValue(180L);
		show.setDonatedTickets(2L);
		show.setOccupancy("40%");
		show.setSeatsAvailable(4L);
		show.setSeatsSold(1L);
		show.setStartingSeatId("21");
		show.setStatus("open");
		show.setTotalAmount(250L);
		show.setShowInfo(showInfo);
		show.setSectionInfo(sectionInfo);
		s.setSeating(seating);
		s.setSectionName("Front right");
		s.setSid("1");
		s.setStartingSeatId("2");
		s.setStatus("open");
		s.setTotalAmount(180);
		s.setWid("7");
		s.setShowInfo(showInfo);
		
		
		assertEquals("7", s.getWid());
		assertEquals(180,s.getTotalAmount().intValue());
		assertEquals("open", s.getStatus());
		assertEquals("2", s.getStartingSeatId());
		assertEquals("1", s.getSid());
		assertEquals("Front right", s.getSectionName());
		assertEquals(seating, s.getSeating());
		assertEquals(showInfo.getName(),s.getShowInfo().getName());
		
		
	}
	@Test
	public void test__anotherparamterizedConstructor()
	{

		Shows show = new Shows();
		Shows show1 = new Shows();
		  ShowInfo showInfo = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
		show.setShowInfo(showInfo);
		show.setSectionInfo(sectionInfo);
		show.setTotalAmount(0L);
		show1.setShowInfo(showInfo);
		show1.setSectionInfo(sectionInfo);
		show1.setTotalAmount(0L);
	
		
		
	
		
		SectionInfo section = new SectionInfo();
		
		seating1.setRow("5");
		seating1.setSeats(seats);
		Seat seat = new Seat();
		seat.setSeat("1");
		seat.setCid("8");
		seat.setStatus("ok");
		seats.add(seat);
		seating1.setSeats(seats);
		seating.add(seating1);
		
		
		Seating newSeating = new Seating(seating1);
		
		
		Seat seat1 = new Seat();
		seat1.setSeat("1");
		seat1.setCid("8");
		seat1.setStatus("ok");
		seat2.add(seat1);
		newSeating.setSeats(seat2);
		seatingList.add(newSeating);
		
        section.setSectionName("Front Right");	
        section.setPrice(75L);
        section.setSeatsAvailable(4L);
        section.setSeatsSold(2L);
        section.setSectionPrice(180L);
        section.setSectionRevenue(450L);
        section.setSid("1");
        section.setSeating(seating);
        
        
        
        sectionInfo.add(section);
		showInfo.setName("Alex");
		showInfo.setTime("12:00");
		showInfo.setWeb("example.com");
		showInfo.setDate("12-01-2017");
		show.setWid("7");
		show.setDonatedAndUsedTickets(3L);
		show.setDonatedAndUsedValue(180L);
		show.setDonatedTickets(2L);
		show.setOccupancy("40%");
		show.setSeatsAvailable(4L);
		show.setSeatsSold(1L);
		show.setStartingSeatId("21");
		show.setStatus("open");
		show.setTotalAmount(250L);
		show.setShowInfo(showInfo);
		show.setSectionInfo(sectionInfo);
		
		
		show1.setWid("7");
		show1.setDonatedAndUsedTickets(3L);
		show1.setDonatedAndUsedValue(180L);
		show1.setDonatedTickets(2L);
		show1.setOccupancy("40%");
		show1.setSeatsAvailable(4L);
		show1.setSeatsSold(1L);
		show1.setStartingSeatId("21");
		show1.setStatus("open");
		show1.setTotalAmount(250L);
		show1.setShowInfo(showInfo);
		show1.setSectionInfo(sectionInfo);
		ShowSections s = new ShowSections(show1);
		s = new ShowSections(show1);
		ShowSections s1	 = new ShowSections(show);
		s1 = new ShowSections(show);
		ShowInfo showinfo = new ShowInfo(show.getShowInfo());
		SeatingShows ss = new SeatingShows(show1);
		SeatingShows ss1 = new SeatingShows(show);
	    
	
		assertEquals(s1.getSeating().get(0).getRow(), s.getSeating().get(0).getRow()); 
		assertEquals(s1.getSeating().get(0).getSeats().get(0).getSeat(), s.getSeating().get(0).getSeats().get(0).getSeat());
		assertEquals(s1.getSeating().get(0).getSeats().get(0).getCid(), s.getSeating().get(0).getSeats().get(0).getCid()); 
		assertEquals(s1.getSeating().get(0).getSeats().get(0).getStatus(), s.getSeating().get(0).getSeats().get(0).getStatus());
		
		assertEquals(ss.getSeating().get(0).getRow(), ss1.getSeating().get(0).getRow()); 
		assertEquals(ss.getSeating().get(0).getSeats().get(0).getSeat(), ss1.getSeating().get(0).getSeats().get(0).getSeat());
		assertEquals(ss.getSeating().get(0).getSeats().get(0).getCid(), ss1.getSeating().get(0).getSeats().get(0).getCid()); 
		assertEquals(ss.getSeating().get(0).getSeats().get(0).getStatus(), ss1.getSeating().get(0).getSeats().get(0).getStatus()); 
		
		assertEquals(s1.getSectionName(), s.getSectionName());
		assertEquals(show.getWid(), s.getWid());	
		
		assertEquals(ss.getSid() ,ss1.getSid());
		assertEquals(ss.getSectionName(), ss1.getSectionName());
		assertEquals(ss.getShowInfo().getName(), ss1.getShowInfo().getName());
		assertEquals(ss.getShowInfo().getDate(), ss1.getShowInfo().getDate());
		assertEquals(ss.getShowInfo().getTime(), ss1.getShowInfo().getTime());
		assertEquals(ss.getShowInfo().getWeb(), ss1.getShowInfo().getWeb());
		assertEquals(ss.getStartingSeatId(), ss1.getStartingSeatId());
		assertEquals(ss.getStatus(), ss1.getStatus());
		assertEquals(ss.getTotalAmount(), ss1.getTotalAmount());
		
		show1.setStartingSeatId("");
		show.setStartingSeatId("");
		ss = new SeatingShows(show1);
		ss1 = new SeatingShows(show);
		
		assertEquals(ss.getStartingSeatId(), ss1.getStartingSeatId());
		
		
		 
		
		
	}


}
