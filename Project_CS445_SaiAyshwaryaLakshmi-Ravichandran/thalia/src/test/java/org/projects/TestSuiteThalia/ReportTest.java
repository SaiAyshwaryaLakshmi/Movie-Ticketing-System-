package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Report;
import org.projects.Thalia.Shows;

public class ReportTest {

	
	Report reports = new Report();
	List<Shows> show;
	
	@Test
	public void test_ReportFieldConstructor()
	{
		reports = new Report("34", "TheatreRevenue");
		 assertEquals("34",reports.getMrid());
	     assertEquals("TheatreRevenue", reports.getName());	
	}

	@Test
	public void test_GettersAndSetters()
	{
		reports.setDonatedAndUsedTickets(123L);
		reports.setDonatedAndUsedValue(75L);
		reports.setDonatedTickets(3L);
		reports.setEndDate("12-08-2018");
		reports.setMrid("123");
		reports.setName("TheatreRevenue");
		reports.setOverallOccupancy("5%");
		reports.setOverallRevenue(10L);
		reports.setSoldSeats(5L);
		reports.setStartDate("12-05-2018");
		reports.setTotalSeats(3L);
		reports.setTotalShows(2L);
		reports.setShows(show);
		
	    assertSame(123L,reports.getDonatedAndUsedTickets());
	    assertSame(75L,reports.getDonatedAndUsedValue());
	    assertSame(3L,reports.getDonatedTickets());
	    assertEquals("12-08-2018",reports.getEndDate());
	    assertEquals("123",reports.getMrid());
	    assertEquals("TheatreRevenue",reports.getName());
	    assertEquals("5%",reports.getOverallOccupancy());
	    assertEquals("12-05-2018",reports.getStartDate());
	    assertEquals(show,reports.getShows());
	    assertSame(10L,reports.getOverallRevenue());
	    assertSame(5L,reports.getSoldSeats());
	    assertSame(3L,reports.getTotalSeats());
	    assertSame(2L,reports.getTotalShows());
	    
	    
	    
	}
}
