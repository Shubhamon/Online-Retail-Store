package com.customer.online.retail.store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CustomerAddress {
	@Id
	@GeneratedValue
	private Long productId;
	@Column(nullable=false,length=50)
	private String doorNo;
	@Column(nullable=false,length=50)
	private String streetName;
	@Column(nullable=false,length=50)
	private String layout;
	@Column(nullable=false,length=50)
	private String city;
	@Column(nullable=false,length=50)
	private String pincode;
	
	
	
	public CustomerAddress() {
		
	}
	public CustomerAddress(Long productId, String doorNo, String streetName, String layout, String city, String pincode) {
		super();
		this.productId = productId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public void addCustomerAddress(){
		System.out.println("New Customer address added:"+toString());
	}
	public void deleteCustomerAddress(){
		System.out.println("Customer address deleted:"+toString());
	}
	public void updateCustomerAddress(){
		System.out.println("Customer address updated:"+toString());
	}
	public CustomerAddress searchCustomerAddress(){
		return this;
	}
}
