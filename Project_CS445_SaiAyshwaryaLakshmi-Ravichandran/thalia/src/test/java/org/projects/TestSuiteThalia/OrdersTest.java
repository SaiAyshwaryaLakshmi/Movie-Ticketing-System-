package org.projects.TestSuiteThalia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.projects.Thalia.Orders;
import org.projects.Thalia.OrdersSectionReceipt;

public class OrdersTest {

	List<OrdersSectionReceipt> orders;
	Orders order = new Orders();
	
	@Test
	public void test_TicketsFieldConstructor() {
		order = new Orders(orders);
		assertEquals(orders,order.getOrders());
	}
	
	@Test
	public void test_SettersANDGetters() {
		order.setOrders(orders);
		assertEquals(orders,order.getOrders());
	}


}
