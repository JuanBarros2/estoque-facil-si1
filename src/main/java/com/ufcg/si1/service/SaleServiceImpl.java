package com.ufcg.si1.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ufcg.si1.model.Product;
import com.ufcg.si1.model.SaleItem;
import exceptions.EntityNotFoundException;
import exceptions.InvalidAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Sale;
import com.ufcg.si1.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private ProductLotService productLotService;

	@Override
	public List<Sale> findAll() {
		return saleRepository.findAll();
	}

	@Override
	public Sale findById(long id) {
		return saleRepository.findOne((int) id);
	}

	@Override
	public Sale save(Sale sale) throws InvalidAmountException, EntityNotFoundException {
		this.discountProductStock(sale.getItems());
		sale.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		return saleRepository.save(sale);
	}

	@Override
	public void delete(long id) throws InvalidAmountException, EntityNotFoundException {
		Sale sale = saleRepository.findOne((int) id);
		this.countProductStock(sale.getItems());
		saleRepository.delete(sale);		
	}

	/**
	 * Receives a list of SaleItem and discounts the items from stock.
	 * @param items
	 */
	private void discountProductStock(List<SaleItem> items) throws InvalidAmountException, EntityNotFoundException {
		for(SaleItem item: items){
			Product product = productLotService.discountProductStock(item.getProduct().getId(), item.getAmount());
			item.setProduct(product);
			item.setPrice(product.getDiscountPrice());
		}
	}
	/**
	 * Receives a list of SaleItem and discounts the items from stock.
	 * @param items
	 */
	private void countProductStock(List<SaleItem> items) throws InvalidAmountException, EntityNotFoundException {
		for(SaleItem item: items){
			Product product = productLotService.countProductStock(item.getProduct().getId(), item.getAmount());
			item.setProduct(product);
			item.setPrice(product.getDiscountPrice());
		}
	}

}
