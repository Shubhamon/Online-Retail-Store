package com.customer.online.retail.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.online.retail.store.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {	

}
