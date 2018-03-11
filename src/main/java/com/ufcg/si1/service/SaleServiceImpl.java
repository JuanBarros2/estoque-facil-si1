package com.ufcg.si1.service;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import com.ufcg.si1.model.SaleItem;
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
	public Sale save(Sale sale) throws InvalidAmountException {
		this.discountProductStock(sale.getItems());
		sale.setSaleDate(new Date());
		return saleRepository.save(sale);
	}

	@Override
	public void delete(long id) {

	}

	/**
	 * Receives a list of SaleItem and discounts the items from stock.
	 * @param items
	 */
	private void discountProductStock(List<SaleItem> items) throws InvalidAmountException {
		for(SaleItem item: items){
			double price = productLotService.discountProductStock(item.getProduct().getId(), item.getAmount());
			item.setPrice(price);
		}
	}

}
