package com.ufcg.si1.repository;

import com.ufcg.si1.model.Produto;
import com.ufcg.si1.model.ProdutoLote;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoLoteRepository extends CrudRepository<ProdutoLote, Long> {
    ProdutoLote findFirstByProdutoId(long id);
    void deleteAllByProdutoId(long id);
    ProdutoLote findFirstByProduto_NomeAndProduto_Fabricante(String nome, String fabricante);
}
