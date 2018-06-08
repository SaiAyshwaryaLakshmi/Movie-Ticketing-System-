package org.projects.TestSuiteThaliaServices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.projects.Thalia.Order;
import org.projects.Thalia.Orders;
import org.projects.Thalia.OrdersReceipt;
import org.projects.Thalia.PatronInfo;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.ShowInfo;
import org.projects.Thalia.Shows;
import org.projects.Thalia.Tickets;
import org.projects.ThaliaServices.OrderServices;
import org.projects.ThaliaUtility.UtilityDataStore;

import com.google.gson.Gson;


public class OrderServicesTest {

	
    OrderServices order = new OrderServices();         
    
	@Test
	public void test() {
		Order order = new Order();
		List <String>tickets = new ArrayList<>();
		tickets.add("737");
		tickets.add("738");
		
		ShowInfo showinfo = new ShowInfo();
		PatronInfo patronInfo = new PatronInfo();
		List<SectionInfo> sectionInfo = new ArrayList<>();
		SectionInfo section = new SectionInfo();
		Seating seating1 = new Seating();
		List <Seat> seats = new ArrayList<>();
		List<Seating> seating = new ArrayList<>();
	
		seating1.setRow("5");
		seating1.setSeats(seats);
		Seat seat = new Seat();
		seat.setSeat("1");
		seat.setCid("8");
		seat.setStatus("ok");
		seats.add(seat);
		seating1.setSeats(seats);
		seating.add(seating1);
		
		List<Seating> seatingList = new ArrayList<>();
		OrdersReceipt oR = new OrdersReceipt();
		section.setSectionName("Front Right");	
        section.setPrice(75L);
        section.setSeatsAvailable(4L);
        section.setSeatsSold(2L);
        section.setSectionPrice(180L);
        section.setSectionRevenue(450L);
        section.setSid("1");
        section.setSeating(seating);
        sectionInfo.add(section);
		sectionInfo.add(section);
		order.setDateOrdered("2017-10-26 11:59");
		order.setOid("412");
		order.setOrderAmount(120L);
		order.setWid("3");
		order.setSid("1");
		oR.setOid("156");
		oR.setWid("89");
		oR.setShowInfo(showinfo);
		oR.setDateOrdered("2018-09-10");
		oR.setOrderAmount(190L);
		oR.setTickets(tickets);
		showinfo.setDate("2017-12-05");
		showinfo.setName("King Lear");
		showinfo.setTime("13:00");
		order.setShowInfo(showinfo);
        patronInfo.setBillingAddress("123 Main ST, Anytown, IL 45678");
        patronInfo.setCcExpirationDate("12/21");
        patronInfo.setCcNumber("1234567890987654");
        patronInfo.setEmail( "john.doe@example.com");
        patronInfo.setName("John Doe");
        patronInfo.setPhone("123-456-7890");
		
	    order.setSeats(seats);
	    order.setPatronInfo(patronInfo);

		Shows show = new Shows();
		ShowInfo showInfo = new ShowInfo();
		showInfo.setDate("2017-12-05");
		showInfo.setName("King Lear");
		showInfo.setTime("13:00");
		showInfo.setWeb("example.com");
		show.setWid("3");
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
		
		
		
		UtilityDataStore.showsMap.put("3", show);
        Gson gson = new Gson();
		String json = gson.toJson(order);
        OrderServices os = new OrderServices();
       
        assertEquals(201,os.postOrder(json).getStatus());
		assertEquals(200,os.getOrdersByDate("01-12-2018", "01-12-2020").getStatus());
		assertEquals(200,os.GetOrders("01-11-2018", "01-12-2020").getStatus());
		assertEquals(200,os.GetOrders("01-11-2018", "").getStatus());
	    assertEquals(200,os.GetSpecificOrder("3").getStatus());
	} 

}
