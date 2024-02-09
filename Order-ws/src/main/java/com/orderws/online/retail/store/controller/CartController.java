package com.orderws.online.retail.store.controller;

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
import com.orderws.online.retail.store.model.Cart;
import com.orderws.online.retail.store.model.LineItem;
import com.orderws.online.retail.store.service.CartService;
import com.orderws.online.retail.store.service.LineItemService;

@RestController
@RequestMapping("/orders")
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
	@GetMapping("/{orderId}")
	public ResponseEntity<Cart> getCart(@PathVariable Long orderId){
		Cart cart=cartService.getCart(orderId);
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	@DeleteMapping("/{orderId}/empty")
	public ResponseEntity<Void> emptyCart(@PathVariable Long orderId){
		cartService.emptyCart(orderId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/{orderId}")
	public ResponseEntity<Cart> updateCart(@PathVariable Long orderId,@RequestBody Cart updatedCart){
		Cart updated=cartService.updateCart(orderId,updatedCart);
		return new ResponseEntity<>(updated,HttpStatus.OK);
	}
	
	@PostMapping("/{orderId}/lineItems")
	public ResponseEntity<LineItem> addLineItem(@PathVariable Long orderId,@RequestBody LineItem lineItem){
		LineItem createdLineItem=lineItemService.addLineItem(lineItem);
		return new ResponseEntity<>(createdLineItem,HttpStatus.CREATED);
	}
	@DeleteMapping("/{orderId}/lineItems/{itemId}")
	public ResponseEntity<Void> deleteLineItem(@PathVariable Long itemId){
		lineItemService.deleteLineItem(itemId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    @GetMapping("/{orderId}/lineItems/{itemId}")
    public ResponseEntity<LineItem> getLineItem(@PathVariable Long orderId,@PathVariable Long itemId){
    	LineItem lineItem=lineItemService.getLineItem(itemId);
    	return new ResponseEntity<>(lineItem,HttpStatus.OK);
    }
    @PutMapping("/{orderId}/lineItems/{itemId}")
    public ResponseEntity<LineItem> updateLineItem(@PathVariable Long orderId,@PathVariable Long itemId,@RequestBody LineItem updatedLineItem){
    	LineItem updated=lineItemService.updateLineItem(itemId,updatedLineItem);
    	return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    
    @GetMapping("/allLineItem/{productId}")
    public ResponseEntity<List<LineItem>> getLineItemByProductId(@PathVariable Long productId) {
        List<LineItem> lineItemList = lineItemService.getLineItemList(productId);
        return new ResponseEntity<>(lineItemList, HttpStatus.OK);
    }
    
    @GetMapping("allOrder/{orderId}")
    public ResponseEntity<List<Cart>> getCartByOrderId(@PathVariable Long orderId){
    	List<Cart> cartList=cartService.getCartByOrderId(orderId);
    	return new ResponseEntity<>(cartList,HttpStatus.OK);
    }
}
