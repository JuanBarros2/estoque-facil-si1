package com.ufcg.si1.service;

import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.ProductLot;

public interface ProductLotService {

	List<ProductLot> findAllProdutos();

	void saveProduto(ProductLot produto);

	ProductLot findById(long id);

	void updateProduto(ProductLot user);

	void deleteProdutoById(long id);

	boolean doesProdutoExist(ProductLot produto);
}
