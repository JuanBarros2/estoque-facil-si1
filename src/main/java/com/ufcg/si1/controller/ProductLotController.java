package com.ufcg.si1.controller;

import com.ufcg.si1.model.DTO.ProductDto;
import com.ufcg.si1.model.Lot;
import com.ufcg.si1.model.ProductLot;
import com.ufcg.si1.model.Role.Module.Constants;
import com.ufcg.si1.service.ProductLotService;
import exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/product")
public class ProductLotController {

    @Autowired
    private ProductLotService productLotService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Iterable<ProductDto> findAll() {
        return productLotService.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/lot/{id}")
    @Secured({Constants.ADM})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> addLot(@PathVariable("id") long produtoId, @RequestBody Lot lot) throws EntityNotFoundException {
        ProductLot updatedProductLot = productLotService.addLot(produtoId, lot);
        return new ResponseEntity<>(new ProductDto(updatedProductLot), HttpStatus.CREATED);
    }
}
