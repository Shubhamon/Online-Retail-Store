package com.orderws.online.retail.store.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Long orderId;
	
	@OneToMany(cascade=CascadeType.ALL)
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
