package com.orderws.online.retail.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orderws.online.retail.store.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

	List<Cart> getCartByOrderId(Long orderId);

}
