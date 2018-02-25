package com.ufcg.si1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lote")
@CrossOrigin
public class LoteController {
 	/*
	LoteService loteService = new LoteServiceImpl();

	@RequestMapping(value = "/{id}/lote", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> criarLote(@PathVariable("id") long produtoId, @RequestBody LoteDTO loteDTO) {
		Produto product = produtoService.findById(produtoId);

		if (product == null) {
			throw new ObjetoInexistenteException("Unable to create lote. Produto with id " + produtoId + " not found.");
		}
		Lote lote = loteService.saveLote(new Lote(product, loteDTO.getNumeroDeItens(), loteDTO.getDataDeValidade()));
		return new ResponseEntity<>(lote, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/lote/", method = RequestMethod.GET)
	public ResponseEntity<List<Lote>> listAllLotess() {
		List<Lote> lotes = loteService.findAllLotes();

		if (lotes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Lote>>(lotes, HttpStatus.OK);
	}
	*/

}
