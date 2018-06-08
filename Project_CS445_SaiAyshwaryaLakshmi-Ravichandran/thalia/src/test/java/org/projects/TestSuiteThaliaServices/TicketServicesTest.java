package org.projects.TestSuiteThaliaServices;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.projects.Thalia.Donations;
import org.projects.Thalia.PatronInfo;
import org.projects.ThaliaServices.ShowServices;
import org.projects.ThaliaServices.TicketServices;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TicketServicesTest {

	@Before
	public  void setup()
	{
	baseURI = "http://localhost";
	port = 8080;
	basePath = "/thalia";
	}

	@Test
	public void test_Donations() { 
		
		Donations donate = new Donations();
		PatronInfo pI = new PatronInfo();
		List<String>tickets = new ArrayList<>();
		tickets.add("184");
		tickets.add("185");
		pI.setName("Madison Tails");
		pI.setPhone("123456789");
		pI.setEmail("swords@something.com");
		pI.setBillingAddress("1 way street, New york, USA");
		pI.setCcNumber("23478909857");
		pI.setCcExpirationDate("09/24");
		donate.setDid("89");
		donate.setCount(3L);
		donate.setStatus("donated");
		donate.setTickets(tickets);
		donate.setPatronInfo(pI);
		donate.setWid("301");
		
		 Gson gson = new Gson();
	     String json = gson.toJson(donate);
	     TicketServices ts = new TicketServices();
	     ts.setTickets(tickets);
	     assertEquals(201,ts.offerDonations(json).getStatus());
	    
		
		 
 }

}
