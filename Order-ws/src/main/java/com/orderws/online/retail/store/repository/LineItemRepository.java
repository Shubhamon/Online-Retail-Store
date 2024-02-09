package com.orderws.online.retail.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.orderws.online.retail.store.model.LineItem;

public interface LineItemRepository extends CrudRepository<LineItem, Long> {

	List<LineItem> getLineItemByProductId(Long productId);

}
