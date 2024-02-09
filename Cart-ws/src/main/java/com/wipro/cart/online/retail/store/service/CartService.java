package com.wipro.cart.online.retail.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.cart.online.retail.store.model.Cart;
import com.wipro.cart.online.retail.store.repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	
	public Cart addCart(Cart cart) {
		return cartRepo.save(cart);
	}
	public Cart getCart(Long cartId) {
		return cartRepo.findById(cartId).orElseThrow(()->new RuntimeException("Cart not found with id: "+cartId));
	}
	public void emptyCart(Long cartId) {
		Cart cart=getCart(cartId);
		cart.getLineItems().clear();
		cartRepo.save(cart);
	}
	@Transactional
	public Cart updateCart(Long cartId,Cart updatedCart) {
		Cart existingCart=getCart(cartId);
		existingCart.setLineItems(updatedCart.getLineItems());
		return cartRepo.save(existingCart);
	}

}
