package com.ufcg.si1.repository;

import com.ufcg.si1.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByNameAndManufacturer(String name, String manufacturer);
}
