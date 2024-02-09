package com.online.retail.store.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.online.retail.store.model.Inventory;



@FeignClient(name="INVENTORY-WS",url="http://localhost:8083")
public interface InventoryFeignClient {
	
	//@GetMapping("/inventorys/{productId}")
	//Inventory getInventoryByProductId(@PathVariable Long productId);
	
	@GetMapping("/inventorys/allInventory/{productId}")
	List<Inventory> getInventoryByProductId(@PathVariable Long productId);
	
	
	

}



