package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Order;
import org.projects.Thalia.PatronInfo;
import org.projects.Thalia.Seat;
import org.projects.Thalia.ShowInfo;

public class OrderTest {

	Order orders = new Order();
	ShowInfo showInfo;
	PatronInfo patronInfo;
	List<Seat> seats;
	@Test
	public void test_OrderFieldConstructor() {
		orders = new Order("89", "308", showInfo, "02/24/2017", 260L, 4L, patronInfo);
		assertEquals("89",orders.getOid());
		assertEquals("308",orders.getWid());
		assertEquals(showInfo, orders.getShowInfo());
		assertEquals("02/24/2017",orders.getDateOrdered());
		assertEquals(260L,orders.getOrderAmount().longValue());
		assertEquals(4L,orders.getNumberOfTickets().longValue());
		assertEquals(patronInfo,orders.getPatronInfo());
		
	}

	@Test
	public void test_GettersAndSetters() {
		
		orders.setOid("56");
		orders.setDateOrdered("02/24/2017");
		orders.setNumberOfTickets(2L);
		orders.setOrderAmount(250L);
		orders.setPatronInfo(patronInfo);
		orders.setSeats(seats);
		orders.setShowInfo(showInfo);
		orders.setSid("4");
		orders.setWid("708");
		
		assertEquals("56",orders.getOid());
		assertEquals("02/24/2017",orders.getDateOrdered());
		assertEquals(2L,orders.getNumberOfTickets().longValue());
		assertEquals(250L,orders.getOrderAmount().longValue());
		assertEquals(seats,orders.getSeats());
		assertEquals(patronInfo,orders.getPatronInfo());
		assertEquals(showInfo,orders.getShowInfo());
		assertEquals("4",orders.getSid());
		assertEquals("708",orders.getWid());
		
		
	}
	
	}

