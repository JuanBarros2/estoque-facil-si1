package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Sale;
import exceptions.EntityNotFoundException;
import exceptions.InvalidAmountException;
import exceptions.ObjetoJaExistenteException;

public interface SaleService {

	List<Sale> findAll();
	
	Sale findById(long id);
	
	Sale save(Sale sale) throws InvalidAmountException, EntityNotFoundException;
	
	void delete(long id);
	
}
