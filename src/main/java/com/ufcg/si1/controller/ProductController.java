package com.ufcg.si1.controller;

import com.ufcg.si1.model.DTO.LotDto;
import com.ufcg.si1.model.DTO.ProductDto;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.ProductLotServiceImpl;

import java.util.ArrayList;
import java.util.List;
import com.ufcg.si1.model.Role.Module.*;


@RestController
@RequestMapping("/produto")
public class ProductController {
	
	@Autowired
	private ProductLotServiceImpl productLotService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Iterable<ProductDto> findAllProdutos(){
		ArrayList<ProductDto> products = new ArrayList<>();
		productLotService.findAllProdutos().forEach(productLot -> products.add(new ProductDto(productLot)) );
		return products;
	}

	@PostMapping
	@Secured({Constants.ADM})
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduto(@RequestBody Product product) throws ObjetoJaExistenteException {

		ProductLot productLot = new ProductLot(product);
		boolean exist = productLotService.doesProdutoExist(productLot);

		if (exist) {
			throw new ObjetoJaExistenteException("O product " + product.getName() + " do fabricante "
					+ product.getManufacturer() + " ja esta cadastrado!");
		}

		productLotService.saveProduto(productLot);
		return product;
	}

	@GetMapping(value = "/{id}")
	@Secured({Constants.ADM})
	public Product searchProduct(@PathVariable("id") long id) throws ObjetoInexistenteException {

		ProductLot p = productLotService.findById(id);

		if (p == null) {
			throw new ObjetoInexistenteException("Product with id " + id + " not found");
		}
		return p.getProduct();
	}

	@PutMapping(value = "{id}")
	@Secured({Constants.ADM})
	public Product updateProduto(@PathVariable("id") long id, @RequestBody Product product) throws ObjetoInexistenteException {

		ProductLot currentProduto = productLotService.findById(id);

		if (currentProduto == null) {
			throw new ObjetoInexistenteException("Unable to update. Product with id " + id + " not found");
		}

		Product productUpdate = currentProduto.getProduct();

		productUpdate.setName(product.getName());
		productUpdate.setPrice(product.getPrice());
		productUpdate.setBarcode(product.getBarcode());
		productUpdate.setManufacturer(product.getManufacturer());
		productUpdate.setCategory(product.getCategory());

		productLotService.updateProduto(currentProduto);
		return productUpdate;
	}

	@DeleteMapping(value = "{id}")
	@Secured({Constants.ADM})
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) throws ObjetoInexistenteException {

		ProductLot productLot = productLotService.findById(id);

		if (productLot == null) {
			throw new ObjetoInexistenteException("Unable to delete. Product with id " + id + " not found.");
		}
		productLotService.deleteProdutoById(id);
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}/lote", method = RequestMethod.POST)
	@Secured({Constants.ADM})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> criarLote(@PathVariable("id") long produtoId, @RequestBody LotDto lotDto)  throws ObjetoInexistenteException{
		ProductLot productLote = productLotService.findById(produtoId);

		if (productLote == null) {
			throw new ObjetoInexistenteException("Unable to create lot. Product with id " + produtoId + " not found.");
		}
		Lot lot = new Lot(lotDto.getItensAmount(), lotDto.getExpirationDate());
		productLote.addLot(lot);
		productLotService.updateProduto(productLote);
		return new ResponseEntity<>(lot, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/lote/", method = RequestMethod.GET)
	@Secured({Constants.ADM})
	public List<ProductLot> listAllLotes() {
		return productLotService.findAllProdutos();
	}

}
