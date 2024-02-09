package com.customer.online.retail.store.controller;

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

import com.customer.online.retail.store.model.Cart;
import com.customer.online.retail.store.model.Customer;
import com.customer.online.retail.store.model.CustomerAddress;
import com.customer.online.retail.store.model.Product;
import com.customer.online.retail.store.service.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;	

	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer createdCustomer=customerService.createCustomer(customer);
		return new ResponseEntity<>(createdCustomer,HttpStatus.CREATED);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId){
		Customer customer=customerService.getCustomer(customerId);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
     @DeleteMapping("/{customerId}")
     public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId){
    	 customerService.deleteCustomer(customerId);
    	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     @PutMapping("/{customerId}")
     public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer){
    	 Customer updated=customerService.updateCustomer(customerId,updatedCustomer);
    	 return new ResponseEntity<>(updated,HttpStatus.OK);
     }
     
     @PostMapping("/{customerId}/addresses")
     public ResponseEntity<Customer> addCustomerAddress(@PathVariable Long customerId,@RequestBody CustomerAddress address){
    	 Customer updatedCustomer=customerService.addCustomerAddress(customerId, address);
    	 return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
     }
     @PutMapping("/{customerId}/addresses/{addressId}")
     public ResponseEntity<Customer> updateCustomerAddress(@PathVariable Long customerId, @PathVariable Long addressId,@RequestBody CustomerAddress customerAddress){
    	 Customer updatedCustomer=customerService.updateCustomerAddress(customerId, addressId, customerAddress);
    	 return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
     }
     @DeleteMapping("/{customerId}/addresses/{addressId}")
     public ResponseEntity<CustomerAddress> deleteCustomerAddress(@PathVariable Long customerId,@PathVariable Long addressId){
    	 customerService.deleteCustomerAddress(customerId, addressId);
    	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
     @GetMapping("/{customerId}/addresses/{addressId}")
     public ResponseEntity<CustomerAddress> getCustomerAddress(@PathVariable Long customerId,@PathVariable Long addressId){
    	 CustomerAddress address=customerService.getCustomerAddress(customerId, addressId);
    	 return new ResponseEntity<>(address,HttpStatus.OK);
     }
     @GetMapping("/allCustomerAddress/{productId}")
	    public ResponseEntity<List<CustomerAddress>> getCustomerAddressByProductId(@PathVariable Long productId) {
	        List<CustomerAddress> customerAddressList = customerService.getCustomerAddressList(productId);
	        return new ResponseEntity<>(customerAddressList, HttpStatus.OK);
	    }

     @GetMapping("/allProduct/{productId}")
     public ResponseEntity<List<Product>> getProductByProductId(@PathVariable Long productId){
    	 List<Product> productList=customerService.getProductList(productId);
    	 return new ResponseEntity<>(productList,HttpStatus.OK);
     }
     @GetMapping("/allOrder/{orderId}")
     public ResponseEntity<List<Cart>> getCartByOrderId(@PathVariable Long orderId){
    	 List<Cart> cartList=customerService.getCartByOrderId(orderId);
    	 return new ResponseEntity<>(cartList,HttpStatus.OK);
     }

}
