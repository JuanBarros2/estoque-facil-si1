package com.ufcg.si1.service;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Produto;
import com.ufcg.si1.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {


	@Autowired
	private ProdutoRepository produtoRepository;

	public Set<Produto> findAllProdutos() {
		return (Set<Produto>) produtoRepository.findAll();
	}

	@Override
	public void saveProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduto(Produto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProdutoById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<Produto> getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doesProdutoExist(Produto produto) {
		// TODO Auto-generated method stub
		return false;
	}

}
