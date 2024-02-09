package com.online.retail.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.retail.store.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> getProductByProductId(Long productId);


}
