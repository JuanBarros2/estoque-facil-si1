package com.ufcg.si1.service;

import com.ufcg.si1.model.Product;
import exceptions.ObjetoJaExistenteException;

public interface ProductService {
    Product update(Product product);

    Product save(Product product) throws ObjetoJaExistenteException;

    Product get(Long id);
}
