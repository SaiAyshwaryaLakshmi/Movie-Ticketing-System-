package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Donations;
import org.projects.Thalia.PatronInfo;

public class DonationsTest {

	Donations donate = new Donations();
	PatronInfo patronInfo;
	List<String>tickets;
	
	@Test
	public void test_DonationsFieldConstructor() {
		donate = new Donations("67", "308", 1L, "donated", tickets, patronInfo);
		assertEquals("67",donate.getDid());
		assertEquals("308",donate.getWid());
		assertEquals(1L,donate.getCount().longValue());
		assertEquals("donated",donate.getStatus());
		assertEquals(tickets,donate.getTickets());
		assertEquals(patronInfo,donate.getPatronInfo());
		
	}

	@Test
	public void test_GettersAndSetters() {
		
		donate.setDid("89");
		donate.setCount(3L);
		donate.setStatus("donated");
		donate.setTickets(tickets);
		donate.setPatronInfo(patronInfo);
		donate.setWid("301");
		
		assertEquals("89",donate.getDid());
		assertEquals("301",donate.getWid());
		assertEquals(3L,donate.getCount().longValue());
		assertEquals("donated",donate.getStatus());
		assertEquals(tickets,donate.getTickets());
		assertEquals(patronInfo,donate.getPatronInfo());
		
	}
	

}
