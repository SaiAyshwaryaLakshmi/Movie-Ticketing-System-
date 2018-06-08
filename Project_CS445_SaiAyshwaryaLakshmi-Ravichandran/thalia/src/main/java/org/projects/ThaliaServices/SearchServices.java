package org.projects.ThaliaServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.projects.Thalia.Order;
import org.projects.Thalia.Orders;
import org.projects.Thalia.OrdersSectionReceipt;
import org.projects.Thalia.Shows;
import org.projects.Thalia.ShowsList;
import org.projects.ThaliaUtility.ExclusionStrategyForTickets;
import org.projects.ThaliaUtility.UtilityDataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/search")
public class SearchServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearch(@QueryParam("topic") String topic, @QueryParam("key") String key) {

		if (topic.equalsIgnoreCase("order")) {
			return getSearchOrder(topic, key);
		} else if (topic.equalsIgnoreCase("shows")) {
			return getSearchShows(topic, key);
		} else {
			return Response.status(Response.Status.OK).entity("NotFound").build();
		}
	}

	private Response getSearchShows(String topic, String key) {
		List<Shows> showsList = new ArrayList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getSearchShows")).setPrettyPrinting().create();
		for (Shows shows : UtilityDataStore.showsMap.values()) {
			Shows showSpecific = new Shows(shows);
			if (showSpecific.getShowInfo().getName().contains(key) || showSpecific.getShowInfo().getWeb().contains(key)
					|| showSpecific.getWid().contains(key)) {
				showsList.add(showSpecific);
			}
		} 
		ShowsList showsListReport = new ShowsList();
		showsListReport.setShows(showsList);
		String s = gson.toJson(showsListReport);
		return Response.status(Response.Status.OK).entity(s).build();
	}

	private Response getSearchOrder(String topic, String key) {
		List<OrdersSectionReceipt> orderSectionList = new ArrayList<>();
		Gson gson = new GsonBuilder().setPrettyPrinting()
				.setExclusionStrategies(new ExclusionStrategyForTickets("getSearchOrder")).setPrettyPrinting().create();
		for (OrdersSectionReceipt orderSection : UtilityDataStore.ordersSectionReceiptMap.values()) {
			if (orderSection.getOid().contains(key) || orderSection.getPatronInfo().getName().contains(key)
					|| orderSection.getPatronInfo().getEmail().contains(key)
					|| orderSection.getShowInfo().getName().contains(key)
					|| orderSection.getShowInfo().getWeb().contains(key)) {
				orderSectionList.add(orderSection);
			}
		}
		Orders order = new Orders();
		order.setOrders(orderSectionList);
		String s = gson.toJson(order);
		return Response.status(Response.Status.OK).entity(s).build();
	}
}
