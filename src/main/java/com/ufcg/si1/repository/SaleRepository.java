package com.ufcg.si1.repository;

import org.springframework.data.repository.CrudRepository;

import com.ufcg.si1.model.Sale;

import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Integer> {
	List<Sale> findAll();
}