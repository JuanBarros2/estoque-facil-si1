package com.ufcg.si1.repository;

import com.ufcg.si1.model.ProductLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLotRepository extends CrudRepository<ProductLot, Long> {

    ProductLot findFirstByProductId(long id);

    void deleteAllByProductId(long id);

    ProductLot findFirstByProduct_NameAndProduct_Manufacturer(String name, String manufacturer);
}
