package com.ufcg.si1.controller;

import com.ufcg.si1.model.Product;
import com.ufcg.si1.service.ProductService;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) throws ObjetoJaExistenteException {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") Long id){
        return productService.get(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

}
