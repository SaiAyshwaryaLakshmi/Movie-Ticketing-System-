package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;

public class ShowInfoTest {
	
	SectionInfo si = new SectionInfo();
	List<Seating> seating;

	@Test
	public void test_ShowInfoFieldConstructor() {
		
     si = new SectionInfo("3", "Front-right", 75L, 2L, 4L, 50L);
     assertEquals("3",si.getSid());
     assertEquals("Front-right",si.getSectionName());
     assertEquals(75L,si.getSectionPrice().longValue());
     assertEquals(2L,si.getSeatsAvailable().longValue());
     assertEquals(4L,si.getSeatsSold().longValue());
     assertEquals(50L,si.getSectionRevenue().longValue());
     
	}
	
	@Test
	public void test_SettersANDGetters() {
		si.setPrice(75L);
		si.setSeating(seating);
		si.setSeatsAvailable(2L);
		si.setSeatsSold(4L);
		si.setSectionName("Front-right");
		si.setSectionPrice(75L);
		si.setSectionRevenue(50L);
		si.setSid("3");
		
		assertEquals(75L,si.getPrice().longValue());
		assertEquals("3",si.getSid());
	     assertEquals("Front-right",si.getSectionName());
	     assertEquals(75L,si.getSectionPrice().longValue());
	     assertEquals(2L,si.getSeatsAvailable().longValue());
	     assertEquals(4L,si.getSeatsSold().longValue());
	     assertEquals(50L,si.getSectionRevenue().longValue());
		
			 
	}

	@Test
	public void test_AnotherParameterizedConstructor() {
		
		si = new SectionInfo("3", "Front-right", 75L);
		assertEquals(75L,si.getPrice().longValue());
		assertEquals("3",si.getSid());
		assertEquals("Front-right",si.getSectionName());
		
	}
}
