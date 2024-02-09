package com.wipro.cart.online.retail.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.cart.online.retail.store.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
