/*
*@author toanb
*@date 16 kwi 2019
**/
package com.me.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.me.model.Mission;
import com.me.model.Product;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Integer>{

	List<Product> findByImageType(String searchTerm);

}
