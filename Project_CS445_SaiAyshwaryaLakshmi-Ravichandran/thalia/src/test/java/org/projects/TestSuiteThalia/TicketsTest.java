package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.projects.Thalia.PatronInfo;
import org.projects.Thalia.Seating;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Tickets;



public class TicketsTest {
 
	Tickets ti = new Tickets();
	ShowInfo sI = new ShowInfo();
	PatronInfo pI = new PatronInfo();
	List<Seating> sE = new ArrayList<Seating>();
	@Test
	public void test_TicketsFieldConstructor() {
		
     ti = new Tickets("123",25L,"open","89",sI,pI,"12","1",sE);
     assertEquals("123",ti.getTid());
     assertEquals("open",ti.getStatus());
     assertEquals("89",ti.getWid());
     assertEquals(sI,ti.getShowInfo());
     assertEquals(pI,ti.getPatronInfo());
     assertEquals("12",ti.getSid());
     assertEquals("1",ti.getSectionName());
     assertEquals(sE,ti.getSeating());
     assertSame(25L,ti.getPrice());
     
	}
	
	@Test
	public void test_SettersANDGetters() {
		ti.setTid("125");
		ti.setPrice(45L);
		ti.setStatus("donated");
		ti.setWid("80");
		ti.setShowInfo(sI);
		ti.setPatronInfo(pI);
		ti.setSid("15");
		ti.setSectionName("3");
		ti.setSeating(sE);
		
		 assertEquals("125",ti.getTid());
	     assertEquals("donated",ti.getStatus());
	     assertEquals("80",ti.getWid());
	     assertEquals(sI,ti.getShowInfo());
	     assertEquals(pI,ti.getPatronInfo());
	     assertEquals("15",ti.getSid());
	     assertEquals("3",ti.getSectionName());
	     assertEquals(sE,ti.getSeating());
	     assertSame(45L,ti.getPrice());	
	}
	

}
