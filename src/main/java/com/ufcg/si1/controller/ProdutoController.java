package com.ufcg.si1.controller;

import com.ufcg.si1.model.DTO.ProdutoDTO;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.ProdutoLoteServiceImpl;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoLoteServiceImpl produtoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Iterable<ProdutoDTO> findAllProdutos(){
		ArrayList<ProdutoDTO> produtos = new ArrayList<>();
		produtoService.findAllProdutos().forEach(produtoLote -> produtos.add(new ProdutoDTO(produtoLote)) );
		return produtos;
	}


	@PostMapping(value = "/adiciona")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criarProduto(@RequestBody Produto produto) throws ObjetoJaExistenteException {

		ProdutoLote produtoLote = new ProdutoLote(produto);
		boolean produtoExiste = produtoService.doesProdutoExist(produtoLote);

		if (produtoExiste) {
			throw new ObjetoJaExistenteException("O produto " + produto.getNome() + " do fabricante "
					+ produto.getFabricante() + " ja esta cadastrado!");
		}

		produtoService.saveProduto(produtoLote);
		return produto;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto consultarProduto(@PathVariable("id") long id) throws ObjetoInexistenteException {

		ProdutoLote p = produtoService.findById(id);

		if (p == null) {
			throw new ObjetoInexistenteException("Produto with id " + id + " not found");
		}
		return p.getProduto();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Produto updateProduto(@PathVariable("id") long id, @RequestBody Produto produto) throws ObjetoInexistenteException {

		ProdutoLote currentProduto = produtoService.findById(id);

		if (currentProduto == null) {
			throw new ObjetoInexistenteException("Unable to update. Produto with id " + id + " not found");
		}

		Produto produtoUpdate = currentProduto.getProduto();

		produtoUpdate.setNome(produto.getNome());
		produtoUpdate.setPreco(produto.getPreco());
		produtoUpdate.setCodigoBarra(produto.getCodigoBarra());
		produtoUpdate.setFabricante(produto.getFabricante());
		produtoUpdate.setCategoria(produto.getCategoria());

		produtoService.updateProduto(currentProduto);
		return produtoUpdate;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) throws ObjetoInexistenteException {

		ProdutoLote user = produtoService.findById(id);

		if (user == null) {
			throw new ObjetoInexistenteException("Unable to delete. Produto with id " + id + " not found.");
		}
		produtoService.deleteProdutoById(id);
		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}

}
