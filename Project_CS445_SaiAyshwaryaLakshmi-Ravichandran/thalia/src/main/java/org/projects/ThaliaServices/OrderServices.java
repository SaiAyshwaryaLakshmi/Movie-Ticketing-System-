package org.projects.ThaliaServices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.projects.Thalia.Order;
import org.projects.Thalia.OrdersReceipt;
import org.projects.Thalia.OrdersSectionReceipt;
import org.projects.Thalia.PatronInfo;
import org.projects.Thalia.Seat;
import org.projects.Thalia.Seating;
import org.projects.Thalia.SectionInfo;
import org.projects.Thalia.Shows;
import org.projects.Thalia.Tickets;
import org.projects.ThaliaUtility.ExclusionStrategyForTickets;
import org.projects.ThaliaUtility.UtilityDataStore;
import org.projects.ThaliaUtility.UniqueIdGenerator;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/orders")
public class OrderServices {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postOrder(String json) {
		Gson gson = new Gson();
		List<String> tickets = new ArrayList<String>();
		PatronInfo p = new PatronInfo();
		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    String date = DATE_FORMAT.format(today);
		Order order = gson.fromJson(json, Order.class);
		OrdersReceipt ordersReceipt = new OrdersReceipt();
		ordersReceipt.setOid(UniqueIdGenerator.getUniqueID().toString());
		ordersReceipt.setWid(order.getWid());
		ordersReceipt.setDateOrdered(date);
		for (int i = 0; i < order.getSeats().size(); i++) {
			String s = UniqueIdGenerator.getUniqueID().toString();
			tickets.add(s);
		} 
		Shows shows = new Shows(UtilityDataStore.showsMap.get(order.getWid()));
		ordersReceipt.setShowInfo(shows.getShowInfo());
		List<SectionInfo> sectionInfoList = shows.getSectionInfo();
		Integer price = null;
		for (SectionInfo sectionInfo : sectionInfoList) {
			if (sectionInfo.getSid().equalsIgnoreCase(order.getSid())) {
				price = (int) (order.getSeats().size() * sectionInfo.getPrice());
				break;
			}
		}
		ordersReceipt.setOrderAmount(price.longValue());
		ordersReceipt.setTickets(tickets);
		String s = gson.toJson(ordersReceipt);
		addOrderToMap(ordersReceipt, order);
		return Response.status(Response.Status.CREATED).entity(s).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetOrders(@QueryParam("start_date") String startDate, @QueryParam("end_date") String endDate) {
		if (startDate == null || endDate == null) {
			Gson gson = new GsonBuilder().setPrettyPrinting()
					.setExclusionStrategies(new ExclusionStrategyForTickets("getOrders")).setPrettyPrinting().create();
			String s = gson.toJson(new ArrayList(UtilityDataStore.ordersSectionReceiptMap.values()));
			return Response.status(Response.Status.OK).entity(s).build();
		} else {
			return getOrdersByDate(startDate, endDate);
		}
	}

	public Response getOrdersByDate(String startDate, String endDate) {
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getOrders")).setPrettyPrinting()
				.create();
		String s;
		List<OrdersSectionReceipt> ordersSectionReceiptList = new ArrayList(
				UtilityDataStore.ordersSectionReceiptMap.values());
		List<OrdersSectionReceipt> ordersFiltered = new ArrayList<>();
		for (OrdersSectionReceipt ordersSection : ordersSectionReceiptList) {
			try {
				
				SimpleDateFormat orderFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
				Date orderDate = orderFormatter.parse(ordersSection.getDateOrdered()); 
				SimpleDateFormat filterDate = new SimpleDateFormat("yyyyMMdd");
				Date start = filterDate.parse(startDate);
				Date end = filterDate.parse(endDate);
				if(start.compareTo(end)==0)
				{
					if (orderDate.compareTo(start) >= 0) {
						ordersFiltered.add(ordersSection);
						
						}
				}
				else
				{
				if (orderDate.compareTo(start) >= 0 && orderDate.compareTo(end) <= 0) {
					ordersFiltered.add(ordersSection);
					}
				}
				
			} catch (Exception ex) {
				s = "{\"Result\":\"Exception\"}";
			}
		}
		s = gson.toJson(ordersFiltered);

		return Response.status(Response.Status.OK).entity(s).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetSpecificOrder(@PathParam("id") String oid) {
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getSpecificOrder")).setPrettyPrinting()
				.create();
		String s;
		if (UtilityDataStore.ordersSectionReceiptMap.containsKey(oid)) {
			s = gson.toJson(UtilityDataStore.ordersSectionReceiptMap.get(oid));
		} else {
			s = "{\"Result\":\"Notfound\"}";
		}
		return Response.status(Response.Status.OK).entity(s).build();
	}

	void addOrderToMap(OrdersReceipt ordersReceipt, Order order) {
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		OrdersSectionReceipt ordersSectionReceipt = new OrdersSectionReceipt();
		ordersSectionReceipt.setOid(ordersReceipt.getOid());
		ordersSectionReceipt.setWid(ordersReceipt.getWid());
		ordersSectionReceipt.setDateOrdered(ordersReceipt.getDateOrdered());
		ordersSectionReceipt.setNumberOfTickets((long) ordersReceipt.getTickets().size());
		order.getPatronInfo().setCcNumber(order.getPatronInfo().getCcNumber());
		ordersSectionReceipt.setPatronInfo(order.getPatronInfo());
		ordersSectionReceipt.setShowInfo(ordersReceipt.getShowInfo());
		ordersSectionReceipt.setOrderAmount(ordersReceipt.getOrderAmount());
		Shows shows = new Shows(UtilityDataStore.showsMap.get(order.getWid()));
		List<SectionInfo> sectionInfoList = shows.getSectionInfo();
		List<Seating> seatingSpecificList = new ArrayList<>();
		List<Seat> seatSpecificList = new ArrayList<>();
		SectionInfo sectionInfoSid = new SectionInfo();
		Seating seatingSpecific = new Seating();
		Boolean seatFound = false;
		for (SectionInfo sectionInfo : sectionInfoList) {
			if (sectionInfo.getSid().equalsIgnoreCase(order.getSid())) {
				sectionInfoSid = new SectionInfo(sectionInfo);
				break;
			}
		}
		int i = 0;
		for (String t : ordersReceipt.getTickets()) {
			Tickets ticket = new Tickets();
			ticket.setPatronInfo(order.getPatronInfo());
			ticket.setPrice(sectionInfoSid.getPrice());
			ticket.setShowInfo(ordersReceipt.getShowInfo());
			for (Seating seating : sectionInfoSid.getSeating()) {
				for (Seat seat : seating.getSeats()) {
					if (seat.getCid().equalsIgnoreCase(order.getSeats().get(i).getCid())) {
						seatSpecificList.add(seat);
						seatFound = true;
						break;
					}
				}
				if (seatFound == true) {
					seatingSpecific = new Seating(seating);
					seatingSpecific.setSeats(seatSpecificList);
					seatingSpecificList.add(seatingSpecific);
					break;
				}
			}

			ticket.setSeating(seatingSpecificList);
			ticket.setSectionName(sectionInfoSid.getSectionName());
			ticket.setStatus("open");
			ticket.setTid(t);
			ticket.setSid(order.getSid());
			ticket.setWid(ordersReceipt.getWid());
			UtilityDataStore.ticketsMap.put(ticket.getTid(), ticket);
			ticketsList.add(ticket);
			i++;
			seatSpecificList = new ArrayList<>();
			seatingSpecificList = new ArrayList();
			seatFound = false;
		}
		ordersSectionReceipt.setTickets(ticketsList);
		ReserveTickets(ticketsList, ordersReceipt.getWid());
		UtilityDataStore.ordersSectionReceiptMap.put(ordersSectionReceipt.getOid(), ordersSectionReceipt);

	}

	void ReserveTickets(List<Tickets> ticketList, String wid) {
		Shows shows = UtilityDataStore.showsMap.get(wid);
		boolean isSeatFound = false;
		for (Tickets ticket : ticketList) {
			isSeatFound = false;
			for (SectionInfo sectionInfo : shows.getSectionInfo()) {
				if (sectionInfo.getSid().equalsIgnoreCase(ticket.getSid())) {
					for (Seating seating : sectionInfo.getSeating()) {
						for (Seat seat : seating.getSeats()) {
							if (seat.getCid().equalsIgnoreCase(ticket.getSeating().get(0).getSeats().get(0).getCid())) {
							isSeatFound = true;
								seat.setStatus("sold");
								shows.setSeatsSold(shows.getSeatsSold() + 1);
								shows.setTotalAmount(shows.getTotalAmount() + sectionInfo.getPrice());
								shows.setOccupancy(
										new Float((float) ((shows.getSeatsSold() * 100) / shows.getSeatsAvailable()))
												.toString() + "%");
								break;
							}
						}
						if (isSeatFound)
							break;
					}
					sectionInfo.setSeatsSold(sectionInfo.getSeatsSold()+1);
					sectionInfo.setSectionRevenue(sectionInfo.getSectionRevenue()+sectionInfo.getPrice());
					break;
				}
			}
		}
	}
}
