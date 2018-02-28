package com.ufcg.si1.repository;

import org.springframework.data.repository.CrudRepository;

import com.ufcg.si1.model.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
	
}