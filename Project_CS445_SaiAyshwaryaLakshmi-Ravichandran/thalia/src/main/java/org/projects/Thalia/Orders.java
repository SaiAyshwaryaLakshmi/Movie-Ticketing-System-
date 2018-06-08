package org.projects.Thalia;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Orders {

@SerializedName("orders")
@Expose
private List<OrdersSectionReceipt> orders = null;

/**
* No args constructor for use in serialization
* 
*/
public Orders() {
}

/**
* 
* @param orders
*/
public Orders(List<OrdersSectionReceipt> orders) {
super();
this.orders = orders;
}

public List<OrdersSectionReceipt> getOrders() {
return orders;
}

public void setOrders(List<OrdersSectionReceipt> orders) {
this.orders = orders;
}

}