package com.ufcg.si1.service;

import com.ufcg.si1.model.Lot;
import com.ufcg.si1.model.Product;
import com.ufcg.si1.model.ProductLot;
import exceptions.EntityNotFoundException;
import exceptions.ObjetoJaExistenteException;

import java.util.List;

public interface ProductLotService {

    List<ProductLot> findAll();

    ProductLot addLot(Long productId, Lot lot) throws EntityNotFoundException;

    ProductLot createFromProduct(Product product);
}
