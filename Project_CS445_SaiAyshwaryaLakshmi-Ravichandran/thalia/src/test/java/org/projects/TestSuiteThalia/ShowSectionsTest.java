package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SeatingShows;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.ShowSections;
import org.projects.Thalia.Shows;

public class ShowSectionsTest {

	
	Shows show = new Shows();
	ShowInfo showInfo = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
	
	List<SectionInfo> sectionInfo = new ArrayList<>();
	List<Seating> seating = new ArrayList<>();
	
	
	@Test
	public void test_gettersANDSetters()
	{
		Shows show = new Shows();
		  ShowInfo showInfo = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
		  show.setShowInfo(showInfo);
		show.setSectionInfo(sectionInfo);
		show.setTotalAmount(0L);
		ShowSections s = new ShowSections(show);
		
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
		s.setPrice(180);
		s.setShowInfo(showInfo);
		s.setWid("4");
		
		assertEquals("4", s.getWid());
		assertEquals(180, s.getPrice().intValue());
		assertEquals("1", s.getSid());
		assertEquals("Front right", s.getSectionName());
		assertEquals(seating, s.getSeating());
		assertEquals(showInfo, s.getShowInfo());
		
	}
	@Test
	public void test__anotherparamterizedConstructor()
	{
		Shows show = new Shows();
		ShowInfo showInfo = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
		  show.setShowInfo(showInfo);
		show.setSectionInfo(sectionInfo);
		show.setTotalAmount(0L);
		
		
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
		ShowSections s = new ShowSections(show);
		ShowSections s1 = new ShowSections(show);
		ShowInfo showinfo = new ShowInfo(show.getShowInfo());

		assertEquals(s.getPrice(), s1.getPrice());
		assertEquals(s.getSeating(),s1.getSeating());
		//assertEquals(s.getShowInfo(),s1.getShowInfo());

		
		
	}

}
