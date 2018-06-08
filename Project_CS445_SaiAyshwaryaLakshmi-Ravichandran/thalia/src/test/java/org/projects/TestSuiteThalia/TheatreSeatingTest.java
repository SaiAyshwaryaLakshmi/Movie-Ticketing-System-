package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.TheatreSeating;

public class TheatreSeatingTest {

	
	TheatreSeating ts = new TheatreSeating();
	List<String> seats;
	
	@Test
	public void test_TheatreSeatingFieldConstructor() {
		ts = new TheatreSeating("3",seats);
		 assertEquals("3",ts.getRow());
         assertEquals(seats,ts.getSeats());
	}
	
	@Test
	public void test_SettersANDGetters() {
		ts.setRow("2");
		ts.setSeats(seats);
		
		 assertEquals("2",ts.getRow());
	     assertEquals(seats,ts.getSeats());

}
}
