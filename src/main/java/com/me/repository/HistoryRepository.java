/*
*@author toanb
*@date 17 kwi 2019
**/
package com.me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.me.model.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Integer>{

}
