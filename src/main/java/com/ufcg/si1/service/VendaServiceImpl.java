package com.ufcg.si1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Venda;
import com.ufcg.si1.repository.VendaRepository;

@Service("vendaService")
public class VendaServiceImpl implements VendaService{
	
	@Autowired
	private VendaRepository vendaRepository;

	@Override
	public List<Venda> findAllVendas() {
		Iterable<Venda> it = vendaRepository.findAll();
		List<Venda> vendas = new ArrayList<>();
		it.forEach(vendas::add);
		return vendas;
	}

	@Override
	public Venda findById(long id) {
		return vendaRepository.findOne((int) id);
	}

	@Override
	public void saveVenda(Venda venda) {
		vendaRepository.save(venda);	
	}

	@Override
	public void deleteVendaById(long id) {
		// TODO Auto-generated method stub
		
	}

}
