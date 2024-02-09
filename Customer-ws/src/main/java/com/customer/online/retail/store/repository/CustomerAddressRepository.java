package com.customer.online.retail.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.customer.online.retail.store.model.CustomerAddress;

public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Long> {
	List<CustomerAddress> getCustomerAddressByProductId(Long productId);

}
