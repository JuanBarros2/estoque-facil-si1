package com.ufcg.si1.controller;

import com.ufcg.si1.model.Category;
import com.ufcg.si1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category product) {
        return categoryService.update(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll() {
        return categoryService.findAll();
    }

}
