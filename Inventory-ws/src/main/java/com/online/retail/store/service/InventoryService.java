package com.online.retail.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.retail.store.model.Inventory;
import com.online.retail.store.repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	public Inventory addInventory(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	public void deleteInventory(Long inventoryId) {
		 inventoryRepo.deleteById(inventoryId);
	}
	public Inventory getInventory(Long inventoryId) {
		return inventoryRepo.findById(inventoryId).orElseThrow(()->new RuntimeException("Inventory not found with id:"+inventoryId));
	}
	@Transactional
	public Inventory updateInventory(Long inventoryId,Inventory updatedInventory) {
		Inventory existingInventory=getInventory(inventoryId);
		
		existingInventory.setProductId(updatedInventory.getProductId());
		existingInventory.setQuantity(updatedInventory.getQuantity());
		return existingInventory;
	}
	
	public List<Inventory> getInventoryList(Long productId) {
		List<Inventory> inventoryList = inventoryRepo.getInventoryByProductId(productId);	
        return inventoryList ;
    }
//	public Inventory getInventorys(Long productId) {
//  Optional<Inventory> inventoryOptional = inventoryRepo.findByProductId(productId);
//  return inventoryOptional.orElse(null);
//}
}
