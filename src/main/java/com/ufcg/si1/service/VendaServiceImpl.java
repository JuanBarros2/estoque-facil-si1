package com.ufcg.si1.service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venda findById(long id) {
		// TODO Auto-generated method stub
		return null;
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
