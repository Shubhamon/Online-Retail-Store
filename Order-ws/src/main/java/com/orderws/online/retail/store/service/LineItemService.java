package com.orderws.online.retail.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderws.online.retail.store.model.LineItem;
import com.orderws.online.retail.store.repository.LineItemRepository;

import jakarta.transaction.Transactional;

@Service
public class LineItemService {
	
	@Autowired
	private LineItemRepository lineItemRepo;
	
	public LineItem addLineItem(LineItem lineItem) {
		return lineItemRepo.save(lineItem);
	}
	
	public void deleteLineItem(Long itemId) {
		 lineItemRepo.deleteById(itemId);
	}
	public LineItem getLineItem(Long itemId) {
		return lineItemRepo.findById(itemId).orElseThrow(()->new RuntimeException("Line Item not found with id: "+itemId));
	}
	@Transactional
	public LineItem updateLineItem(Long itemId,LineItem updatedLineItem) {
		LineItem existingLineItem=getLineItem(itemId);
		
		existingLineItem.setProductId(updatedLineItem.getProductId());
		existingLineItem.setProductName(updatedLineItem.getProductName());
		existingLineItem.setQuantity(updatedLineItem.getQuantity());
		existingLineItem.setPrice(updatedLineItem.getPrice());
		
		return lineItemRepo.save(existingLineItem);
	}
	public List<LineItem> getLineItemList(Long productId) {
        return lineItemRepo.getLineItemByProductId(productId);
    }

}
