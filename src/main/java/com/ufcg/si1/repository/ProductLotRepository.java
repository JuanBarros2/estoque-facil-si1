package com.ufcg.si1.repository;

import com.ufcg.si1.model.ProductLot;
import exceptions.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLotRepository extends CrudRepository<ProductLot, Long> {
    List<ProductLot> findAll();

    ProductLot findByProductId(Long productId);
}
