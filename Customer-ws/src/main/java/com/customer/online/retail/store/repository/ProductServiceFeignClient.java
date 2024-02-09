package com.customer.online.retail.store.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.online.retail.store.model.Product;

@FeignClient(name="PRODUCT-WS",url="http://localhost:8082")
public interface ProductServiceFeignClient {
	
   
	@GetMapping("/products/allProduct/{productId}")
	List<Product> getProductByProductId(@PathVariable Long productId);
    
}
