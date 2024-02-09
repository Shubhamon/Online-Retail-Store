package com.online.retail.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.retail.store.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	List<Inventory> getInventoryByProductId(Long productId);

}
