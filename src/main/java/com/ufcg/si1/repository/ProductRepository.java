package com.ufcg.si1.repository;

import com.ufcg.si1.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Product, Long> {
}
