package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import org.junit.Test;
import org.projects.Thalia.ShowInfo;

public class SectionInfoTest {

	

	ShowInfo si = new ShowInfo();

	@Test
	public void test_ShowInfoFieldConstructor() {
		
     si = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
     assertEquals("Madison Heights",si.getName());
     assertEquals("www.shows.com",si.getWeb());
     assertEquals("12-09-2016",si.getDate());
     assertEquals("14:00",si.getTime());
     
	}
	
	@Test
	public void test_SettersANDGetters() {
		si.setName("Madison Tails");
		si.setWeb("www.showshere.com");
		si.setTime("14:00");
		si.setDate("12-10-2017");
		
			 assertEquals("Madison Tails",si.getName());
		     assertEquals("www.showshere.com",si.getWeb());
		     assertEquals("12-10-2017",si.getDate());
		     assertEquals("14:00",si.getTime());
			
	}
}
