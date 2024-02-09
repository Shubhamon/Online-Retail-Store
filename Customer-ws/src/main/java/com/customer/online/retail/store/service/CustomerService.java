package com.customer.online.retail.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.online.retail.store.model.Cart;
import com.customer.online.retail.store.model.Customer;
import com.customer.online.retail.store.model.CustomerAddress;
import com.customer.online.retail.store.model.Product;
import com.customer.online.retail.store.repository.CustomerAddressRepository;
import com.customer.online.retail.store.repository.CustomerRepository;
import com.customer.online.retail.store.repository.OrderServiceFeignClient;
import com.customer.online.retail.store.repository.ProductServiceFeignClient;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerAddressRepository  customerAddressRepo;
	
	@Autowired
	private ProductServiceFeignClient productWsClient;
	
	@Autowired
	private OrderServiceFeignClient orderWsClient;
	
	
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer getCustomer(Long customerId) {
		return customerRepo.findById(customerId).orElseThrow(()->new RuntimeException("Customer not found "+customerId));
	}
    
	public void deleteCustomer(Long customerId) {
	 customerRepo.deleteById(customerId);
	}
	@Transactional
	public Customer updateCustomer(Long customerId,Customer updatedCustomer) {
		Customer existingCustomer=getCustomer(customerId);
		
		existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
		existingCustomer.setCustomerEmail(updatedCustomer.getCustomerEmail());
		existingCustomer.setCustomerBillingAddress(updatedCustomer.getCustomerBillingAddress());
		existingCustomer.setCustomerShippingAddress(updatedCustomer.getCustomerShippingAddress());
		return existingCustomer;
	}
	
	public Customer addCustomerAddress(Long customerId,CustomerAddress address) {
		Customer customer=getCustomer(customerId);
		customer.addCustomerAddress(address);
		return customerRepo.save(customer);
	}
	public Customer updateCustomerAddress(Long customId,Long addressId,CustomerAddress updatedAddress) {
		Customer customer=getCustomer(customId);
		customer.updateCustomerAddress(updatedAddress);
		return customerRepo.save(customer);
	}
	public void deleteCustomerAddress(Long customerId,Long addressId) {
		Customer customer=getCustomer(customerId);
		customer.deleteCustomerAddress();
		customerRepo.save(customer);
	}
	public CustomerAddress getCustomerAddress(Long customerId,Long addressId) {
		Customer customer=getCustomer(customerId);
		return customer.getCustomerBillingAddress();
	}
	public List<CustomerAddress> getCustomerAddressList(Long productId) {
        return customerAddressRepo.getCustomerAddressByProductId(productId);
    }
	
	public List<Product> getProductList(Long customerId){
		return productWsClient.getProductByProductId(customerId);
	
	}
	public List<Cart> getCartByOrderId(Long orderId){
		return orderWsClient.getCartByOrderId(orderId);
	}

}
