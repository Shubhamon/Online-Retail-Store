package com.customer.online.retail.store.model;

import java.util.List;

public class Cart {

	private Long orderId;
	
	
	private List<LineItem> lineItems;
	
	public Cart() {}

	public Cart(Long orderId, List<LineItem> lineItems) {
		super();
		this.orderId = orderId;
		this.lineItems = lineItems;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	

}
