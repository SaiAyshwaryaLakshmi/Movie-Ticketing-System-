package org.projects.TestSuiteThaliaServices;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.projects.Thalia.Donations;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SeatingShows;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;
import org.projects.Thalia.TheatreSeating;
import org.projects.Thalia.TheatreSection;
import org.projects.ThaliaServices.OrderServices;
import org.projects.ThaliaServices.SeatingServices;
import org.projects.ThaliaServices.ShowServices;
import org.projects.ThaliaUtility.UtilityDataStore;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ShowServicesTest {

	

	@Test
	 public void testShowService() {
		Shows show = new Shows();
		Shows s = new Shows();
		ShowInfo showInfo = new ShowInfo("Madison Heights","www.shows.com","12-09-2016","14:00");
		
		List<SectionInfo> sectionInfo = new ArrayList<>();
		Seating seating1 = new Seating();
		List <Seat> seats = new ArrayList<>(); 
		List<Seating> seating = new ArrayList<>();
		SectionInfo section = new SectionInfo();
	    
		List<String> seatd = new ArrayList<>();
		TheatreSection ts = new TheatreSection();
		TheatreSeating ts1 = new TheatreSeating();
		List <TheatreSeating> tseating = new ArrayList<>();
		ts1.setRow("2");
		ts1.setSeats(seatd);
		ts.setSeating(tseating);
		ts.setSectionName("6");
		ts.setSid("7");
		
		seating1.setRow("5");
		seating1.setSeats(seats);
		Seat seat = new Seat();
		seat.setSeat("1");
		seat.setCid("8");
		seat.setStatus("ok");
		seats.add(seat);
		seating1.setSeats(seats);
		seating.add(seating1);
		
	    
	     section.setSectionName("Front Right");	
	        section.setPrice(75L);
	        section.setSeatsAvailable(4L);
	        section.setSeatsSold(2L);
	        section.setSectionPrice(180L);
	        section.setSectionRevenue(450L);
	        section.setSid("111");
	        section.setSeating(seating);
	        sectionInfo.add(section);
	showInfo.setName("Alex");
	showInfo.setTime("12:00");
	showInfo.setWeb("example.com");
	showInfo.setDate("12-01-2017");
	show.setWid("708");
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
	show.setSectionInfo(sectionInfo);
	s = new Shows(show);
	ShowInfo showinfo = new ShowInfo(show.getShowInfo());
	
	 Gson gson = new Gson(); 
     String json = gson.toJson(s);
     ShowServices os = new ShowServices();
     UtilityDataStore.theatreSectionMap.put("111", ts);
     assertEquals(201,os.createShow(json).getStatus());
     assertEquals(200,os.getAllShows().getStatus());
     assertEquals(200,os.getShow("708").getStatus());
     assertEquals(200,os.getShowSection("708").getStatus());
     assertEquals(404,os.getShowSpecificSection("708", "111").getStatus());
     assertEquals(201,os.setDonations("708", json).getStatus());
	 assertEquals("{\"Result\":\"Notfound\"}",os.getShow("7").getEntity().toString());
	 assertEquals(200,os.getDonations("8", "9").getStatus());
	 assertEquals("{\"Result\":\"Notfound\"}",os.getShowSection("1").getEntity().toString());
	 assertEquals(200,os.getDonations("8", "9").getStatus()); 
	
		
/*String rs= given().
contentType("application/json; charset=UTF-16").
body(show).
post("/shows").getBody().prettyPrint() ;
assertTrue(rs.contains("wid"));;

String r= given().
contentType("application/json; charset=UTF-16").
body(show).
get("/shows/129").getBody().prettyPrint() ;


int p = given().
contentType("application/json; charset=UTF-16").
body(show).
put("/shows/30").getStatusCode();
assertEquals(200,p);

String g = given().
contentType("application/json; charset=UTF-16").
body(show).
get("/shows/129/sections").getBody().prettyPrint() ;
//assertTrue(g.contains("null"));

String h = given().
contentType("application/json; charset=UTF-16").
body(show).
post("/shows/86/donations").getBody().prettyPrint() ;
//assertTrue(g.contains("null"));


String i = given().
contentType("application/json; charset=UTF-16").
body(show).
post("/shows/86/donations/97").getBody().prettyPrint() ;
//assertTrue(g.contains("null"));


String j = given().
contentType("application/json; charset=UTF-16").
body(show).
post("/86/sections/1").getBody().prettyPrint() ;
//assertTrue(g.contains("null"));
*/
    


}
}