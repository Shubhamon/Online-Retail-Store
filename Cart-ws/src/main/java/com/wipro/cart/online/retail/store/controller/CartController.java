package com.wipro.cart.online.retail.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wipro.cart.online.retail.store.model.Cart;
import com.wipro.cart.online.retail.store.model.LineItem;
import com.wipro.cart.online.retail.store.service.CartService;
import com.wipro.cart.online.retail.store.service.LineItemService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private LineItemService lineItemService;
	
	@PostMapping("/create")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
		Cart createdCart=cartService.addCart(cart);
		return new ResponseEntity<>(createdCart,HttpStatus.CREATED);
	}
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCart(@PathVariable Long cartId){
		Cart cart=cartService.getCart(cartId);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	@DeleteMapping("/{cartId}/empty")
	public ResponseEntity<Void> emptyCart(@PathVariable Long cartId){
		cartService.emptyCart(cartId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCart(@PathVariable Long cartId,@RequestBody Cart updatedCart){
		Cart updated=cartService.updateCart(cartId,updatedCart);
		return new ResponseEntity<>(updated,HttpStatus.OK);
	}
	
	@PostMapping("/{cartId}/lineItems")
	public ResponseEntity<LineItem> addLineItem(@PathVariable Long cartId,@RequestBody LineItem lineItem){
		LineItem createdLineItem=lineItemService.addLineItem(lineItem);
		return new ResponseEntity<>(createdLineItem,HttpStatus.CREATED);
	}
	@DeleteMapping("/{cartId}/lineItems/{itemId}")
	public ResponseEntity<Void> deleteLineItem(@PathVariable Long itemId){
		lineItemService.deleteLineItem(itemId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    @GetMapping("/{cartId}/lineItems/{itemId}")
    public ResponseEntity<LineItem> getLineItem(@PathVariable Long cartId,@PathVariable Long itemId){
    	LineItem lineItem=lineItemService.getLineItem(itemId);
    	return new ResponseEntity<>(lineItem,HttpStatus.OK);
    }
    @PutMapping("/{cartId}/lineItems/{itemId}")
    public ResponseEntity<LineItem> updateLineItem(@PathVariable Long cartId,@PathVariable Long itemId,@RequestBody LineItem updatedLineItem){
    	LineItem updated=lineItemService.updateLineItem(itemId,updatedLineItem);
    	return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    
    @GetMapping("/allLineItem/{productId}")
    public ResponseEntity<List<LineItem>> getLineItemByProductId(@PathVariable Long productId) {
        List<LineItem> lineItemList = lineItemService.getLineItemList(productId);
        return new ResponseEntity<>(lineItemList, HttpStatus.OK);
    }
}
