package com.wipro.cart.online.retail.store.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Long cartId;
	
	@OneToMany(cascade=CascadeType.ALL)
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
