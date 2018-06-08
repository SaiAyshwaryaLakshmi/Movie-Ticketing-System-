package org.projects.TestSuiteThaliaServices;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.projects.Thalia.Report;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;
import org.projects.ThaliaServices.ReportServices;
import org.projects.ThaliaServices.SearchServices;
import org.projects.ThaliaUtility.UtilityDataStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReportServicesTest {

	/*@Before
	public  void setup()
	{
	baseURI = "http://localhost";
	port = 8080;
	basePath = "/thalia";
	}

	@Test
	public void test_GETtickets() { 
		
	    int code = get("/reports").statusCode();
	    assertEquals(200,code);
		get("/reports").then().assertThat().contentType(ContentType.JSON);
		Response response = when().get("/reports").then().contentType(ContentType.JSON).extract().response();	
		String s = response.getBody().prettyPrint();
		assertTrue(s.contains("mrid"));
		assertTrue(s.contains("Theatre occupancy"));
		assertTrue(s.contains("Revenue from ticket sales"));
		assertTrue(s.contains("Donated tickets report"));
		System.out.println(s);
		
	}*/
	
	@Test
	 public void test_ClassReportServices()
	 {
	   
		UtilityDataStore.initializeReportsMap();
		String mrid = null;
		for(Report reporr:UtilityDataStore.reportsMap.values())
		{
			mrid=reporr.getMrid();
			break;
		}
		ReportServices report = new ReportServices();
		assertEquals(200,report.getReportForAllShows(mrid).getStatus());
		assertEquals(200,report.getReportForShowsInDateRange(mrid, "20180123", "20200123").getStatus());
		Shows show = new Shows();
		ShowInfo showInfo = new ShowInfo();
		List<SectionInfo> section = new ArrayList<>();
	
		showInfo.setDate("2017-12-05");
		showInfo.setName("King Lear");
		showInfo.setTime("13:00");
		showInfo.setWeb("example.com");
		show.setWid("596");
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
		
		UtilityDataStore.showsMap.put("596", show);
		assertEquals(200,report.getReportForSpecificShow(mrid, "596").getStatus());
		assertEquals(200,report.getReports().getStatus());
		assertEquals(200,report.getSpecificReports(mrid, "596", "20180123", "20200123").getStatus());
	 }

}
