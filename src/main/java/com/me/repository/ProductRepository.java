/*
*@author toanb
*@date 16 kwi 2019
**/
package com.me.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.me.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	List<Product> findByMissionNameContaining(String searchTerm);
	List<Product> findByTakenDateLessThan(Timestamp searchTerm);
	List<Product> findByTakenDateBetween(Timestamp searchTerm, Timestamp searchTerm2);
	List<Product> findByTakenDateGreaterThan(Timestamp searchTerm);
}
