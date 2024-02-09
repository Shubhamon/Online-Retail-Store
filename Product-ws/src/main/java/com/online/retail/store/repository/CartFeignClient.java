package com.online.retail.store.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.online.retail.store.model.LineItem;

@FeignClient(name="CART-WS",url="http://localhost:8084")
public interface CartFeignClient {
	
	@GetMapping("/carts/allLineItem/{productId}")
	List<LineItem> getLineItemByProductId(@PathVariable Long productId);

}
