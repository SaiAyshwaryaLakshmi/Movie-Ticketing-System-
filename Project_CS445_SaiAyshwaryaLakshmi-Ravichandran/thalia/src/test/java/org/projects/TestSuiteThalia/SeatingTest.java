package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;

public class SeatingTest {
		
		Seating seating = new Seating();
		List <Seat> seats = new ArrayList<>();
		List<Seat> seat2 = new ArrayList<>();

		@Test
		public void test_TicketsFieldConstructor() {
			
	     seating = new Seating("5", seats);
	     assertEquals("5", seating.getRow());
	     assertEquals(seats, seating.getSeats());
	     
		}
		
		@Test
		public void test_SettersANDGetters() {
			seating.setRow("5");
			seating.setSeats(seats);
			
				 assertEquals("5",seating.getRow());
			     assertEquals(seats, seating.getSeats());		
		}

		@Test
		public void anotherParameterizedConstructor() {
			seating.setRow("5");
			seating.setSeats(seats);
			Seat seat = new Seat();
			seat.setSeat("1");
			seats.add(seat);
			seating.setSeats(seats);
			
			Seating newSeating = new Seating(seating);
			
			Seat seat1 = new Seat();
			seat1.setSeat("1");
			seat2.add(seat1);
			newSeating.setSeats(seat2);
			
				 assertEquals(seating.getRow(),newSeating.getRow());
			     assertEquals(seating.getSeats(), seating.getSeats());		
		}

	}



