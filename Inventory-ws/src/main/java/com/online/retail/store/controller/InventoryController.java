package com.online.retail.store.controller;

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

import com.online.retail.store.model.Inventory;
import com.online.retail.store.service.InventoryService;

@RestController
@RequestMapping("/inventorys")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/create")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		Inventory createdInventory = inventoryService.addInventory(inventory);
		return new ResponseEntity<>(createdInventory, HttpStatus.CREATED);
	}

	@DeleteMapping("/{inventoryId}")
	public ResponseEntity<Inventory> deleteInventory(@PathVariable Long inventoryId) {
		inventoryService.deleteInventory(inventoryId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{inventoryId}")
	public ResponseEntity<Inventory> getInventory(@PathVariable Long inventoryId) {
		Inventory inventory = inventoryService.getInventory(inventoryId);
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}

	@PutMapping("/{inventoryId}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable Long inventoryId,
			@RequestBody Inventory updatedInventory) {
		Inventory updated = inventoryService.updateInventory(inventoryId, updatedInventory);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}

	@GetMapping("/allInventory/{productId}")
	public ResponseEntity<List<Inventory>> getInventoryByProductId(@PathVariable Long productId) {
		List<Inventory> inventoryList = inventoryService.getInventoryList(productId);
		return new ResponseEntity<>(inventoryList, HttpStatus.OK);
	}
//		@GetMapping("/all/{productId}")
//		public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId){
//			Inventory inventory=inventoryService.getInventorys(productId);
//			return new ResponseEntity<>(inventory,HttpStatus.OK);
//		}

}
