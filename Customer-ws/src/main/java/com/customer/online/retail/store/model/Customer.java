package com.customer.online.retail.store.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long customerId;
	private String customerName;
	private String customerEmail;
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerAddress customerBillingAddress;
	@OneToOne(cascade=CascadeType.ALL)
	private CustomerAddress customerShippingAddress;
   
	
	public Customer() {
		
	}

	public Customer(Long customerId, String customerName, String customerEmail, CustomerAddress customerBillingAddress,
			CustomerAddress customerShippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
		
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public CustomerAddress getCustomerBillingAddress() {
		return customerBillingAddress;
	}
	public void setCustomerBillingAddress(CustomerAddress customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}
	
	
	public CustomerAddress getCustomerShippingAddress() {
		return customerShippingAddress;
	}
	public void setCustomerShippingAddress(CustomerAddress customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}
	
	public void addCustomerAddress(CustomerAddress customerAddress) {
		if(this.customerBillingAddress==null) {
		this.customerBillingAddress=customerAddress;
		}else if(this.customerShippingAddress==null) {
			this.customerShippingAddress=customerAddress;
		}else {
			throw new RuntimeException("Both addresses are already set for the customer");
		}
	}
	public void deleteCustomerAddress() {
		this.customerBillingAddress=null;
		this.customerShippingAddress=null;
	}
	public void updateCustomerAddress(CustomerAddress customerAddress) {
		if(customerBillingAddress!=null) {
		this.customerBillingAddress=customerAddress;
		}else if (customerShippingAddress!=null){
			this.customerShippingAddress=customerAddress;
		}else {
			throw new RuntimeException("No Address found to update");
		}
	}
	public CustomerAddress searchCustomerAddress() {
		return this.customerBillingAddress;
	}

}
