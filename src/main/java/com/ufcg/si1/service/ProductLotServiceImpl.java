package com.ufcg.si1.service;

import java.util.*;

import com.ufcg.si1.model.Product;
import com.ufcg.si1.model.ProductLot;
import com.ufcg.si1.repository.ProductLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLotServiceImpl implements ProductLotService {

	@Autowired
	private ProductLotRepository productLotRepository;

	@Override
	public List<ProductLot> findAllProdutos() {
		Iterable<ProductLot> it = productLotRepository.findAll();
		List<ProductLot> productLots = new ArrayList<>();
		it.forEach(productLots::add);
		return productLots;
	}

	@Override
	public void saveProduto(ProductLot produto) {
		productLotRepository.save(produto);
	}

	@Override
	public ProductLot findById(long id) {
		return productLotRepository.findFirstByProductId(id);
	}

	@Override
	public void updateProduto(ProductLot user) {
		productLotRepository.save(user);
	}

	@Override
	public void deleteProdutoById(long id) {
		productLotRepository.deleteAllByProductId(id);
	}

	@Override
	public boolean doesProdutoExist(ProductLot productLot) {
		Product product = productLot.getProduct();
		productLot = productLotRepository.findFirstByProduct_NameAndProduct_Manufacturer(product.getName(), product.getManufacturer());
		return  productLot != null;
	}

}
