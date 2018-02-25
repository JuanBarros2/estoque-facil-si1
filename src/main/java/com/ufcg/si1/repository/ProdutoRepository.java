package com.ufcg.si1.repository;

import com.ufcg.si1.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
