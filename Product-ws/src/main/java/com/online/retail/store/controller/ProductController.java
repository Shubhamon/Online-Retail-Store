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
import com.online.retail.store.model.LineItem;
import com.online.retail.store.model.Product;
import com.online.retail.store.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
     
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product createdProduct=productService.addProduct(product);
		return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
	}
	@DeleteMapping("/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long productId){
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable Long productId){
		Product product=productService.getProduct(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long productId,@RequestBody Product updatedProduct){
		Product updated=productService.updateProduct(productId, updatedProduct);
		return new ResponseEntity<>(updated,HttpStatus.OK);
	}
	@GetMapping("/allProduct/{productId}")
	public ResponseEntity<List<Product>> getProductByProductId(@PathVariable Long productId) {
		List<Product> productList = productService.getProductList(productId);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	@GetMapping("/allInventory/{productId}")
    public ResponseEntity<List<Inventory>> getInventoryByProductId(@PathVariable Long productId) {
        List<Inventory> inventoryList = productService.getInventoryList(productId);
        return new ResponseEntity<>(inventoryList, HttpStatus.OK);
    }
	@GetMapping("/allLineItem/{productId}")
	public ResponseEntity<List<LineItem>> getCartByProductId(@PathVariable Long productId){
		List<LineItem> lineItemList=productService.getLineItemList(productId);
		return new ResponseEntity<>(lineItemList,HttpStatus.OK);
	}
}
