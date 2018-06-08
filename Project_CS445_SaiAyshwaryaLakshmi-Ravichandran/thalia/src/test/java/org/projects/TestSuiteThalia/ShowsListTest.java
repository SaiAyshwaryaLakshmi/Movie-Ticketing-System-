package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Shows;
import org.projects.Thalia.ShowsList;

public class ShowsListTest {

	ShowsList sl = new ShowsList();
	List<Shows> shows;
	@Test
	public void test_GettersAndSetters()
	{
		sl.setShows(shows);
		assertEquals(shows,sl.getShows());
	}

}
