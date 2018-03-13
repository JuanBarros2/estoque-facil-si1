package com.ufcg.si1.controller;

import com.ufcg.si1.service.SaleService;
import exceptions.EntityNotFoundException;
import exceptions.InvalidAmountException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.ufcg.si1.model.Role.Module.Constants;
import com.ufcg.si1.model.Sale;

@RestController
@RequestMapping("/venda")
@CrossOrigin
public class SaleController {
	
    @Autowired 
    private SaleService saleService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Secured({Constants.ADM})
    public Iterable<Sale> findAll(){
        return saleService.findAll();
    }

    @PostMapping
    @Secured({Constants.ADM})
    public Sale add(@RequestBody Sale sale) throws InvalidAmountException, EntityNotFoundException {
        return saleService.save(sale);
    }

}
