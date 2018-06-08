package org.projects.ThaliaServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.projects.Thalia.Donations;
import org.projects.Thalia.OrdersSectionReceipt;
import org.projects.Thalia.Tickets;
import org.projects.ThaliaUtility.UtilityDataStore;
import org.projects.ThaliaUtility.UniqueIdGenerator;

import com.google.gson.Gson;

@Path("/tickets")
public class TicketServices {

	@POST
	@Path("/donations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response offerDonations(String json) {

		Gson gson = new Gson();
		Donations donations = gson.fromJson(json, Donations.class);

		for (String s : donations.getTickets()) {
			UtilityDataStore.subscriptionList.add(s);
		}
		String s = gson.toJson(UtilityDataStore.responseMap);
		setTickets(donations.getTickets());
		return Response.status(Response.Status.CREATED).entity(s).build();
	}

	public void setTickets(List<String> donatedTickets) {
		boolean isTicketFound = false;
		for (String s : donatedTickets) {
			isTicketFound = false;
			for (OrdersSectionReceipt receipt : UtilityDataStore.ordersSectionReceiptMap.values()) {
				for (Tickets ticket : receipt.getTickets()) {
					if (ticket.getTid().equalsIgnoreCase(s)) {
						ticket.setStatus("donated");
						break;
					}
				}
				if (isTicketFound)
					break;
			}
		}
	} 
}
