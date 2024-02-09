package com.wipro.cart.online.retail.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.cart.online.retail.store.model.LineItem;

public interface LineItemRepository extends CrudRepository<LineItem, Long> {

	List<LineItem> getLineItemByProductId(Long productId);

}
