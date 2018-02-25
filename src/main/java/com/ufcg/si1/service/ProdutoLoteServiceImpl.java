package com.ufcg.si1.service;

import java.util.*;
import com.ufcg.si1.model.ProdutoLote;
import com.ufcg.si1.repository.ProdutoLoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("produtoService")
public class ProdutoLoteServiceImpl implements ProdutoLoteService {

	@Autowired
	private ProdutoLoteRepository produtoLoteRepository;

	@Override
	public Set<ProdutoLote> findAllProdutos() {
		Iterable<ProdutoLote> it = produtoLoteRepository.findAll();
		Set<ProdutoLote> produtos = new HashSet<>();
		it.forEach(produtos::add);
		return produtos;
	}

	@Override
	public void saveProduto(ProdutoLote produto) {
		produtoLoteRepository.save(produto);
	}

	@Override
	public ProdutoLote findById(long id) {
		return produtoLoteRepository.findFirstByProdutoId(id);
	}

	@Override
	public void updateProduto(ProdutoLote user) {
		produtoLoteRepository.save(user);
	}

	@Override
	public void deleteProdutoById(long id) {
		produtoLoteRepository.deleteAllByProdutoId(id);
	}

	@Override
	public long size() {
		return produtoLoteRepository.count();
	}

	@Override
	public Iterator<ProdutoLote> getIterator() {
		Iterable<ProdutoLote> iterable = produtoLoteRepository.findAll();
		return iterable.iterator();
	}

	@Override
	public boolean doesProdutoExist(ProdutoLote produto) {
		return produtoLoteRepository.exists(produto.getId());
	}

}
