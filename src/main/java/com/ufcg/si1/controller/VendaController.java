package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.ufcg.si1.model.Role.Module.Constants;
import com.ufcg.si1.model.Sale;
import com.ufcg.si1.service.SaleServiceImpl;

@RestController
@RequestMapping("/venda")
@CrossOrigin
public class VendaController {
	
    @Autowired 
    private SaleServiceImpl vendaService;
    
    @GetMapping(value = "/registro")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Secured({Constants.ADM})
    public Iterable<Sale> findAllVendas(){
        return vendaService.findAllVendas();
    }

}
