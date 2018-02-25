package com.ufcg.si1.service;

import java.util.Iterator;
import java.util.Set;

import com.ufcg.si1.model.DTO.ProdutoDTO;
import com.ufcg.si1.model.Produto;
import com.ufcg.si1.model.ProdutoLote;

public interface ProdutoLoteService {

	Set<ProdutoLote> findAllProdutos();

	void saveProduto(ProdutoLote produto);

	ProdutoLote findById(long id);

	void updateProduto(ProdutoLote user);

	void deleteProdutoById(long id);

	long size();

	Iterator getIterator();

	boolean doesProdutoExist(ProdutoLote produto);
}
