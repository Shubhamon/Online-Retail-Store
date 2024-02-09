package com.online.retail.store.model;


import java.util.List;


public class Cart {

	private Long cartId;
	
	
	private List<LineItem> lineItems;
	
	public Cart() {}

	public Cart(Long cartId, List<LineItem> lineItems) {
		super();
		this.cartId = cartId;
		this.lineItems = lineItems;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	

}

