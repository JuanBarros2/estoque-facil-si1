package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Venda;

public interface VendaService {

	List<Venda> findAllVendas();
	
	Venda findById(long id);
	
	void saveVenda(Venda venda);
	
	void deleteVendaById(long id);
	
}
