package org.projects.TestSuiteThaliaServices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;
import org.projects.ThaliaServices.SearchServices;
import org.projects.ThaliaServices.SeatingServices;
import org.projects.ThaliaUtility.UtilityDataStore;

public class SearchServicesTest {

	 @Test
	 public void test_ClassSearchServices()
	 {
		 SearchServices s = new SearchServices();
		 UtilityDataStore.initializeReportsMap();
		 Shows show = new Shows();
			ShowInfo showInfo = new ShowInfo();
			List<SectionInfo> section = new ArrayList<>();
			
			showInfo.setName("Alex");
			showInfo.setTime("12:00"); 
			showInfo.setWeb("example.com");
			showInfo.setDate("12-01-2017");
			show.setWid("1000");
			show.setDonatedAndUsedTickets(3L);
			show.setDonatedAndUsedValue(180L);
			show.setDonatedTickets(2L);
			show.setOccupancy("40%");
			show.setSeatsAvailable(4L);
			show.setSeatsSold(1L);
			show.setStartingSeatId("21");
			show.setStatus("open"); 
			show.setTotalAmount(250L);
			show.setShowInfo(showInfo);
			show.setSectionInfo(section);
			UtilityDataStore.showsMap.put("1000",show);
		 assertEquals(200,s.getSearch("order", "1").getStatus());
	     assertEquals(200,s.getSearch("shows", "1000").getStatus());
		 assertEquals(200,s.getSearch("seating", "2").getStatus());
	 }
}
