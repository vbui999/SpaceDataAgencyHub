/*
*@author toanb
*@date 16 kwi 2019
**/
package com.me.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.me.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{
	
	List<Cart> findByCustomerId(int customerId);

}
