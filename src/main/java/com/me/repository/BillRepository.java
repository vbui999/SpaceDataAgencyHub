/*
*@author toanb
*@date 16 kwi 2019
**/
package com.me.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.me.model.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer>{

	List<Bill> findByCustomerId(int customerId);

}
