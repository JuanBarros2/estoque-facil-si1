package com.ufcg.si1.service;


import com.ufcg.si1.model.Lot;
import com.ufcg.si1.model.Product;
import com.ufcg.si1.model.ProductLot;
import com.ufcg.si1.repository.ProductLotRepository;
import exceptions.EntityNotFoundException;
import exceptions.InvalidAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ProductLotServiceImpl implements ProductLotService {

    @Autowired
    private ProductLotRepository productLotRepository;

    @Override
    public List<ProductLot> findAll() {
        return productLotRepository.findAll();
    }

    @Override
    public ProductLot addLot(Long productId, Lot lot) throws EntityNotFoundException {
        ProductLot productLote = productLotRepository.findByProductId(productId);
        if (productLote == null) {
            throw new EntityNotFoundException("Produto não encontrado");
        }

        productLote.addLot(lot);
        return productLotRepository.save(productLote);
    }

    @Override
    public ProductLot createFromProduct(Product product) {
        ProductLot productLot = new ProductLot(product);
        return productLotRepository.save(productLot);
    }

    @Override
    public double discountProductStock(Long productId, int amount) throws InvalidAmountException{
        ProductLot productLot = productLotRepository.findByProductId(productId);
        Iterator<Lot> iterator = productLot.getLots().iterator();
        while (iterator.hasNext() && amount > 0){
            Lot lot = iterator.next();
            int currentAmount = lot.getItensAmount();
            int newAmount = currentAmount - amount ;
            amount -= currentAmount;
            lot.setItensAmount(newAmount);
        }

        if(amount > 0){
            throw new InvalidAmountException("Não existem " + productLot.getProduct() + " suficientes");
        }

        productLotRepository.save(productLot);
        return productLot.getProduct().getDiscountPrice();
    }
}
