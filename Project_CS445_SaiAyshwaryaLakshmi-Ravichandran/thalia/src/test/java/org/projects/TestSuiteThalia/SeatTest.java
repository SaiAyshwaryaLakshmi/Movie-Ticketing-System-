package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import org.junit.Test;
import org.projects.Thalia.Seat;
import org.projects.Thalia.ShowInfo;

public class SeatTest {
	
	Seat seat = new Seat();
	
	@Test
	public void test_TicketsFieldConstructor() {
		
     seat = new Seat("34","available","open");
     assertEquals("34",seat.getCid());
     assertEquals("available",seat.getSeat());
     assertEquals("open",seat.getStatus());
     
	}
	
	@Test
	public void test_SettersANDGetters() {
	         seat.setCid("56");
	         seat.setSeat("available");
	         seat.setStatus("donated");
		
			 assertEquals("56",seat.getCid());
		     assertEquals("available",seat.getSeat());
		     assertEquals("donated",seat.getStatus());
		    
	}

	@Test
	public void test_AnotherParameterizedConstructor() {
		
		Seat s = new Seat(seat);
		assertEquals(seat.getCid(),s.getCid());
		assertEquals(seat.getSeat(),s.getSeat());
		assertEquals(seat.getStatus(),s.getStatus());
		
	}
}
