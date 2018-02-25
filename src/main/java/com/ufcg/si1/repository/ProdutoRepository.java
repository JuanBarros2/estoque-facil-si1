package com.ufcg.si1.repository;

import org.springframework.data.repository.CrudRepository;

import com.ufcg.si1.model.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, Long>{
		
	Produto findProdutoByNome(String nome);
	int countAllById();

}
