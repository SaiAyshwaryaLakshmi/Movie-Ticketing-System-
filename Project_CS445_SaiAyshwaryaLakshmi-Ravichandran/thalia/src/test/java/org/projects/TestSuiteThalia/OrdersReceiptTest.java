package org.projects.TestSuiteThalia;
import org.projects.*;
import org.projects.Thalia.OrdersReceipt;
import org.projects.Thalia.PatronInfo;
import org.projects.Thalia.ShowInfo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrdersReceiptTest {

	OrdersReceipt oR = new OrdersReceipt();
	ShowInfo showinfo;
	PatronInfo patronInfo;
	List<String> tickets;
	
	@Test
	public void test_TicketsFieldConstructor() {
		
     oR = new OrdersReceipt("123", "79", showinfo, "2018-09-10", 180L, tickets);
     assertEquals("123",oR.getOid());
     assertEquals("79",oR.getWid());
     assertEquals(showinfo,oR.getShowInfo());
     assertEquals("2018-09-10",oR.getDateOrdered()); 
     assertEquals(180L,oR.getOrderAmount().longValue());
     assertEquals(tickets,oR.getTickets());
    
	}
	
	@Test
	public void test_SettersANDGetters() {
		oR.setOid("156");
		oR.setWid("89");
		oR.setShowInfo(showinfo);
		oR.setDateOrdered("2018-09-10");
		oR.setOrderAmount(190L);
		oR.setTickets(tickets);
		
		 assertEquals("156",oR.getOid());
	     assertEquals("89",oR.getWid());
	     assertEquals(showinfo,oR.getShowInfo());
	     assertEquals("2018-09-10",oR.getDateOrdered()); 
	     assertEquals(190L,oR.getOrderAmount().longValue());
	     assertEquals(tickets,oR.getTickets());
	}



}
