package com.ufcg.si1.controller;

import com.ufcg.si1.model.Category;
import com.ufcg.si1.model.Role.Module.Constants;
import com.ufcg.si1.service.CategoryServiceImpl;
import exceptions.ObjetoInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categoria")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Secured({Constants.ADM})
    public Iterable<Category> findAllCategoria(){
        return categoryService.findAllCategoria();
    }

    @PutMapping(value = "{id}")
    @Secured({Constants.ADM})
    public Category updateCategoria(@PathVariable("id") long id, @RequestBody Category category) throws ObjetoInexistenteException {

        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null) {
            throw new ObjetoInexistenteException("Unable to update. Product with id " + id + " not found");
        }

        currentCategory.setDiscount(category.getDiscount());
        currentCategory.setName(category.getName());

        categoryService.updateCategoria(currentCategory);
        return currentCategory;
    }
}
