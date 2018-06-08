package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.projects.Thalia.OrdersSectionReceipt;
import org.projects.Thalia.PatronInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Tickets;

public class OrdersSectionReceiptTest {

	OrdersSectionReceipt oR = new OrdersSectionReceipt();
	ShowInfo showinfo;
	PatronInfo patronInfo;
	List<Tickets> tickets = new ArrayList<Tickets>();
	
	@Test
	public void test_TicketsFieldConstructor() {
		
     oR = new OrdersSectionReceipt("124", "78", showinfo, "2018-09-10", 180L, 5L, patronInfo, tickets);
     assertEquals("124",oR.getOid());
     assertEquals("78",oR.getWid());
     assertEquals(showinfo,oR.getShowInfo());
     assertEquals("2018-09-10",oR.getDateOrdered()); 
     assertEquals(patronInfo,oR.getPatronInfo());
     assertEquals(tickets,oR.getTickets());
     assertSame(5L,oR.getNumberOfTickets());
     assertEquals(180L,oR.getOrderAmount().longValue());
    
	}
	
	@Test
	public void test_SettersANDGetters() {
		oR.setOid("127");
		oR.setWid("89");
		oR.setShowInfo(showinfo);
		oR.setDateOrdered("2014-10-10");
		oR.setOrderAmount(75L);
		oR.setNumberOfTickets(3L);
		oR.setPatronInfo(patronInfo);
		oR.setTickets(tickets);
			 assertEquals("127",oR.getOid());
		     assertEquals("89",oR.getWid());
		     assertEquals(showinfo,oR.getShowInfo());
		     assertEquals("2014-10-10",oR.getDateOrdered());
		     assertSame(75L,oR.getOrderAmount());
		     assertSame(3L,oR.getNumberOfTickets());
		     assertEquals(patronInfo,oR.getPatronInfo());
		     assertEquals(tickets,oR.getTickets());	
	}



}
