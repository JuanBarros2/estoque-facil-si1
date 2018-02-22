package com.ufcg.si1.service;

import java.util.Iterator;
import java.util.Set;

import com.ufcg.si1.model.Produto;

public interface ProdutoService {

	Set<Produto> findAllProdutos();

	void saveProduto(Produto produto);

	Produto findById(long id);

	void updateProduto(Produto user);

	void deleteProdutoById(long id);

	int size();

	Iterator<Produto> getIterator();

	boolean doesProdutoExist(Produto produto);
}
