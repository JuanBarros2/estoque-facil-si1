package com.ufcg.si1.controller;

import com.ufcg.si1.model.DTO.LoteDTO;
import com.ufcg.si1.model.DTO.ProdutoDTO;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.ProdutoLoteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import com.ufcg.si1.model.Papel.Modulo.*;


@RestController
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
	@Secured({Constants.ADM})
	@ResponseStatus(HttpStatus.CREATED)
	public Produto createProduto(@RequestBody Produto produto) throws ObjetoJaExistenteException {

		ProdutoLote produtoLote = new ProdutoLote(produto);
		boolean produtoExiste = produtoService.doesProdutoExist(produtoLote);

		if (produtoExiste) {
			throw new ObjetoJaExistenteException("O produto " + produto.getNome() + " do fabricante "
					+ produto.getFabricante() + " ja esta cadastrado!");
		}

		produtoService.saveProduto(produtoLote);
		return produto;
	}

	@GetMapping(value = "/{id}")
	@Secured({Constants.ADM})
	public Produto consultarProduto(@PathVariable("id") long id) throws ObjetoInexistenteException {

		ProdutoLote p = produtoService.findById(id);

		if (p == null) {
			throw new ObjetoInexistenteException("Produto with id " + id + " not found");
		}
		return p.getProduto();
	}

	@PutMapping(value = "{id}")
	@Secured({Constants.ADM})
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

	@DeleteMapping(value = "{id}")
	@Secured({Constants.ADM})
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) throws ObjetoInexistenteException {

		ProdutoLote user = produtoService.findById(id);

		if (user == null) {
			throw new ObjetoInexistenteException("Unable to delete. Produto with id " + id + " not found.");
		}
		produtoService.deleteProdutoById(id);
		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}/lote", method = RequestMethod.POST)
	@Secured({Constants.ADM})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> criarLote(@PathVariable("id") long produtoId, @RequestBody LoteDTO loteDTO)  throws ObjetoInexistenteException{
		ProdutoLote productLote = produtoService.findById(produtoId);

		if (productLote == null) {
			throw new ObjetoInexistenteException("Unable to create lote. Produto with id " + produtoId + " not found.");
		}
		Lote lote = new Lote(loteDTO.getNumeroDeItens(), loteDTO.getDataDeValidade());
		productLote.adicionarLote(lote);
		produtoService.updateProduto(productLote);
		return new ResponseEntity<>(lote, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/lote/", method = RequestMethod.GET)
	@Secured({Constants.ADM})
	public List<ProdutoLote> listAllLotes() {
		return produtoService.findAllProdutos();
	}

}
