package com.ufcg.si1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Sale;
import com.ufcg.si1.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	private SaleRepository saleRepository;

	@Override
	public List<Sale> findAllVendas() {
		Iterable<Sale> it = saleRepository.findAll();
		List<Sale> sales = new ArrayList<>();
		it.forEach(sales::add);
		return sales;
	}

	@Override
	public Sale findById(long id) {
		return saleRepository.findOne((int) id);
	}

	@Override
	public void saveVenda(Sale sale) {
		saleRepository.save(sale);
	}

	@Override
	public void deleteVendaById(long id) {
		// TODO Auto-generated method stub
		
	}

}
