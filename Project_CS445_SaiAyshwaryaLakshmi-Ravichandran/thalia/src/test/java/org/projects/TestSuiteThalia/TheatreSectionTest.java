package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.projects.Thalia.TheatreSeating;
import org.projects.Thalia.TheatreSection;

public class TheatreSectionTest {

	TheatreSection ts = new TheatreSection();
	List<TheatreSeating> tseating = new ArrayList<TheatreSeating>();
	@Test
	public void test_TheatreSectionFieldConstructor() {
		ts= new TheatreSection("4",tseating);
	     assertEquals("4",ts.getSectionName());
	     assertEquals(tseating,ts.getSeating());
	}

	@Test
	public void test_SettersANDGetters() {
		ts.setSeating(tseating);
		ts.setSectionName("6");
		ts.setSid("7");
		
		 assertEquals(tseating,ts.getSeating());
	     assertEquals("6",ts.getSectionName());
	     assertEquals("7",ts.getSid());
		
	}
}
