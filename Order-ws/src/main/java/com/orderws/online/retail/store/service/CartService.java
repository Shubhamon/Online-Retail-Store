package com.orderws.online.retail.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderws.online.retail.store.model.Cart;
import com.orderws.online.retail.store.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	
	public Cart addCart(Cart cart) {
		return cartRepo.save(cart);
	}
	public Cart getCart(Long orderId) {
		return cartRepo.findById(orderId).orElseThrow(()->new RuntimeException("Cart not found with id: "+orderId));
	}
	public void emptyCart(Long orderId) {
		Cart cart=getCart(orderId);
		cart.getLineItems().clear();
		cartRepo.save(cart);
	}
	public Cart updateCart(Long orderId,Cart updatedCart) {
		Cart existingCart=getCart(orderId);
		existingCart.setLineItems(updatedCart.getLineItems());
		return cartRepo.save(existingCart);
	}
	
	public List<Cart> getCartByOrderId(Long orderId){
		return cartRepo.getCartByOrderId(orderId);
	}

}
