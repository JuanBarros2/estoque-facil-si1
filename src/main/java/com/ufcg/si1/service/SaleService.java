package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Sale;

public interface SaleService {

	List<Sale> findAllVendas();
	
	Sale findById(long id);
	
	void saveVenda(Sale sale);
	
	void deleteVendaById(long id);
	
}
