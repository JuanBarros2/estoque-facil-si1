package com.ufcg.si1.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.ProdutoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoServiceImpl produtoService;
	
	@GetMapping(value = "/listarTodos")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Set<Produto> findAllProdutos(){
		return produtoService.findAllProdutos();
	}

}
