package com.customer.online.retail.store.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.online.retail.store.model.Cart;

@FeignClient(name="ORDER-WS",url="http://localhost:8085")
public interface OrderServiceFeignClient {
	
	@GetMapping("orders/allOrder/{orderId}")
	List<Cart> getCartByOrderId(@PathVariable Long orderId);

}
