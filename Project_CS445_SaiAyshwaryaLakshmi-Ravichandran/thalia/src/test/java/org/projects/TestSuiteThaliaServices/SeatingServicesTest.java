package org.projects.TestSuiteThaliaServices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SeatingShows;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;
import org.projects.Thalia.TheatreSeating;
import org.projects.Thalia.TheatreSection;
import org.projects.ThaliaServices.SearchServices;
import org.projects.ThaliaServices.SeatingServices;
import org.projects.ThaliaUtility.UtilityDataStore;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SeatingServicesTest {

	/*@Before
	public  void setup()
	{
	baseURI = "http://localhost";
	port = 8080;
	basePath = "/thalia";
	}
	
	@Test
	public void test_GETSeating() { 
		
	    int code = get("/seating").statusCode();
	    assertEquals(200,code);
		get("/seating").then().assertThat().contentType(ContentType.JSON);
		Response response = when().get("/seating").then().contentType(ContentType.JSON).extract().response();	
		String s = response.getBody().prettyPrint();
		assertTrue(s.contains("Front right"));
		assertTrue(s.contains("Front center"));
		assertTrue(s.contains("Front left"));
		assertTrue(s.contains("Main center"));
		assertTrue(s.contains("Main right"));
		assertTrue(s.contains("Main left"));
		assertTrue(s.contains("sid"));
		assertTrue(s.contains("section_name"));

		
 }
	@Test
	public void test_GETSeatingID() { 
		
		
	    int code = get("/seating/123").statusCode();
	    assertEquals(200,code);
		get("/seating/123").then().assertThat().contentType(ContentType.JSON);
		Response response = when().get("/seating/123").then().contentType(ContentType.JSON).extract().response();	
		String s = response.getBody().prettyPrint();
	
		
 }*/
	   
 @Test
 public void test_ClassSeatingServices()
 {
	 List<String> seatd = new ArrayList<>();
		TheatreSection ts = new TheatreSection();
		TheatreSeating ts1 = new TheatreSeating();
		List <TheatreSeating> tseating = new ArrayList<>();
		Seating seating1 = new Seating();
		List <Seat> seats = new ArrayList<>(); 
		List<Seating> seating = new ArrayList<>();
		SectionInfo section = new SectionInfo();
		ts1.setRow("2");
		ts1.setSeats(seatd);
		ts.setSeating(tseating);
		ts.setSectionName("6");
		ts.setSid("111");
		seating1.setRow("5");
		seating1.setSeats(seats);
		Seat seat = new Seat();
		seat.setSeat("1234");
		seat.setCid("8");
		seat.setStatus("ok");
		seats.add(seat);
		seating1.setSeats(seats);
		seating.add(seating1);
	 UtilityDataStore.theatreSectionMap.put("111", ts);
	 SearchServices s = new SearchServices();
	 UtilityDataStore.initializeReportsMap();
	 Shows show = new Shows();
		ShowInfo showInfo = new ShowInfo();
		List<SectionInfo> section1 = new ArrayList<>();
		 
		  section.setSectionName("Front Right");	
	        section.setPrice(75L);
	        section.setSeatsAvailable(4L);
	        section.setSeatsSold(2L);
	        section.setSectionPrice(180L);
	        section.setSectionRevenue(450L);
	        section.setSid("111");
	        section.setSeating(seating);
	        section1.add(section);
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
		show.setSectionInfo(section1);
		SeatingShows s2 = new SeatingShows(show);
		s2.setSeating(seating);
		s2.setSectionName("Front right");
		s2.setSid("111");
		s2.setStartingSeatId("2");
		s2.setStatus("open"); 
		s2.setTotalAmount(180);
		s2.setWid("1000");
		s2.setShowInfo(showInfo);
	 UtilityDataStore.showsMap.put("1000",show);
	 SeatingServices s1 = new SeatingServices();
	 s1.postConstruct();
	 assertEquals(200,s1.getSpecificSection("111").getStatus()); 
	 assertEquals(200,s1.getSections("1000", "111", "1", "8").getStatus());
     assertEquals(200,s1.getSections("1000", "111", "1", null).getStatus());
     assertEquals(200,s1.getSections("", "111", "1", "8").getStatus());
	  
 }
}