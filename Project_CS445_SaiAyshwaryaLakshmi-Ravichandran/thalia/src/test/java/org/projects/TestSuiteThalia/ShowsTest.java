package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;

public class ShowsTest {

	Shows show = new Shows();
	Shows s = new Shows();
	ShowInfo showInfo = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
	
	List<SectionInfo> sectionInfo = new ArrayList<>();
	
	@Test
	public void test_FirstParameterizedConstructor()
	{
		show = new Shows("607", showInfo, 3L,1L, "40%");
		 assertEquals("607",show.getWid());
	     assertEquals(showInfo,show.getShowInfo());
	     assertEquals(3L,show.getSeatsAvailable().longValue());
	     assertEquals(1L,show.getSeatsSold().longValue());
	     assertEquals("40%",show.getOccupancy());
	}
	
	@Test
	public void test_SecondParameterizedConstructor()
	{
		show = new Shows("406", showInfo, "34", "2",75L,sectionInfo);
		 assertEquals("406",show.getWid());
	     assertEquals(showInfo,show.getShowInfo());
	     assertEquals(sectionInfo,show.getSectionInfo());
	}
	
	@Test
	public void test_ThirdParameterizedConstructor()
	{
		show = new Shows("708", showInfo, 4L, 1L, 2L, 3L, 180L);
		assertEquals("708",show.getWid());
	    assertEquals(showInfo,show.getShowInfo());
	    assertEquals(4L,show.getSeatsAvailable().longValue());
	    assertEquals(1L,show.getSeatsSold().longValue());
	    assertEquals(2L,show.getDonatedTickets().longValue());
	    assertEquals(3L,show.getDonatedAndUsedTickets().longValue());
	    assertEquals(180L,show.getDonatedAndUsedValue().longValue());
	    
	}

	@Test
	public void test_GettersAndSetters()
	{
		show.setWid("708");
		show.setDonatedAndUsedTickets(3L);
		show.setDonatedAndUsedValue(180L);
		show.setDonatedTickets(2L);
		show.setOccupancy("40%");
		show.setSeatsAvailable(4L);
		show.setSeatsSold(1L);
		show.setSectionInfo(sectionInfo);
		show.setShowInfo(showInfo);
		show.setStartingSeatId("21");
		show.setStatus("open");
		show.setTotalAmount(250L);
		
		assertEquals("708",show.getWid());
	    assertEquals(showInfo,show.getShowInfo());
	    assertEquals(4L,show.getSeatsAvailable().longValue());
	    assertEquals(1L,show.getSeatsSold().longValue());
	    assertEquals(2L,show.getDonatedTickets().longValue());
	    assertEquals(3L,show.getDonatedAndUsedTickets().longValue());
	    assertEquals(180L,show.getDonatedAndUsedValue().longValue());
	    assertEquals("40%",show.getOccupancy());
	    assertEquals(250L,show.getTotalAmount().longValue());
	    assertEquals("open",show.getStatus());
	    assertEquals("21",show.getStartingSeatId());
	    
	    
	}
	
	@Test
	public void test__anotherparamterizedConstructor()
	{       List<SectionInfo> sectionInfo = new ArrayList<>();
			Seating seating1 = new Seating();
			List <Seat> seats = new ArrayList<>();
			List<Seating> seating = new ArrayList<>();
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
		s = new Shows(show);
		ShowInfo showinfo = new ShowInfo(show.getShowInfo());
		
		assertEquals(show.getWid(), s.getWid());
		assertEquals(show.getDonatedAndUsedTickets(), s.getDonatedAndUsedTickets());
		assertEquals(show.getDonatedAndUsedValue(), s.getDonatedAndUsedValue());
		assertEquals(show.getDonatedTickets(), s.getDonatedTickets());
		assertEquals(show.getOccupancy(), s.getOccupancy());
		assertEquals(show.getOccupancy(), s.getOccupancy());
		assertEquals(show.getSeatsAvailable(), s.getSeatsAvailable());
		assertEquals(show.getSeatsSold(), s.getSeatsSold());
		assertEquals(show.getSectionInfo().get(0).getSeatsAvailable(), s.getSectionInfo().get(0).getSeatsAvailable());
		assertEquals(show.getStartingSeatId(), s.getStartingSeatId());
		assertEquals(show.getSectionInfo().get(0).getPrice(),s.getSectionInfo().get(0).getPrice());
		assertEquals(show.getStatus(), s.getStatus());
		assertEquals(show.getTotalAmount(), s.getTotalAmount());
	}
}
