package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Papel.Modulo.Constants;
import com.ufcg.si1.model.Venda;
import com.ufcg.si1.service.VendaServiceImpl;

@RestController
@RequestMapping("/venda")
@CrossOrigin
public class VendaController {
	
    @Autowired 
    private VendaServiceImpl vendaService;
    
    @GetMapping(value = "/registro")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Secured({Constants.ADM})
    public Iterable<Venda> findAllVendas(){
        return vendaService.findAllVendas();
    }

}
