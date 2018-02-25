package com.ufcg.si1.controller;

import java.util.List;

import com.ufcg.si1.model.DTO.LoteDTO;
import com.ufcg.si1.util.CustomErrorType;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.ProdutoServiceImpl;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoServiceImpl produtoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Iterable<Produto> findAllProdutos(){
		return produtoService.findAllProdutos();
	}


	@PostMapping(value = "/adiciona")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criarProduto(@RequestBody Produto produto, UriComponentsBuilder ucBuilder) throws ObjetoJaExistenteException {

		boolean produtoExiste = produtoService.doesProdutoExist(produto);

		if (produtoExiste) {
			throw new ObjetoJaExistenteException("O produto " + produto.getNome() + " do fabricante "
					+ produto.getFabricante() + " ja esta cadastrado!");
		}
		produtoService.saveProduto(produto);
		return produto;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto consultarProduto(@PathVariable("id") long id) throws ObjetoInexistenteException {

		Produto p = produtoService.findById(id);

		if (p == null) {
			throw new ObjetoInexistenteException("Produto with id " + id + " not found");
		}
		return p;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Produto updateProduto(@PathVariable("id") long id, @RequestBody Produto produto) throws ObjetoInexistenteException {

		Produto currentProduto = produtoService.findById(id);

		if (currentProduto == null) {
			throw new ObjetoInexistenteException("Unable to update. Produto with id " + id + " not found");
		}

		currentProduto.setNome(produto.getNome());
		currentProduto.setPreco(produto.getPreco());
		currentProduto.setCodigoBarra(produto.getCodigoBarra());
		currentProduto.setFabricante(produto.getFabricante());
		currentProduto.setCategoria(produto.getCategoria());

		produtoService.updateProduto(currentProduto);
		return currentProduto;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) throws ObjetoInexistenteException {

		Produto user = produtoService.findById(id);

		if (user == null) {
			throw new ObjetoInexistenteException("Unable to delete. Produto with id " + id + " not found.");
		}
		produtoService.deleteProdutoById(id);
		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}

}
