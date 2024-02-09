package com.online.retail.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.retail.store.model.Inventory;
import com.online.retail.store.model.LineItem;
import com.online.retail.store.model.Product;
import com.online.retail.store.repository.CartFeignClient;
import com.online.retail.store.repository.InventoryFeignClient;
import com.online.retail.store.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private InventoryFeignClient inventoryWsClient;
	
	@Autowired
	private CartFeignClient cartWsClient;
	
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	public void deleteProduct(Long productid) {
		productRepo.deleteById(productid);
	}
	public Product getProduct(Long productId) {
		return productRepo.findById(productId).orElseThrow(()->new RuntimeException("Product not found with id: "+productId));
	}
	@Transactional
	public Product updateProduct(Long productId,Product updatedProduct) {
		Product existingProduct=getProduct(productId);
		
		existingProduct.setProductName(updatedProduct.getProductName());
		existingProduct.setProductDescription(updatedProduct.getProductDescription());
		existingProduct.setProductPrice(updatedProduct.getProductPrice());
		return existingProduct;
	}
	public List<Product> getProductList(Long productId) {
		List<Product> productList = productRepo.getProductByProductId(productId);	
        return productList ;
    }

	public List<Inventory> getInventoryList(Long productId) {
        return inventoryWsClient.getInventoryByProductId(productId);
    }
	
	public List<LineItem> getLineItemList(Long productId) {
		return cartWsClient.getLineItemByProductId(productId);
	}

}
