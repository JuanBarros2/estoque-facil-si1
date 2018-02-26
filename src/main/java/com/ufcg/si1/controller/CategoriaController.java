package com.ufcg.si1.controller;

import com.ufcg.si1.model.Categoria;
import com.ufcg.si1.model.Papel.Modulo.Constants;
import com.ufcg.si1.service.CategoriaServiceImpl;
import exceptions.ObjetoInexistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Secured({Constants.ADM})
    public Iterable<Categoria> findAllCategoria(){
        return categoriaService.findAllCategoria();
    }

    @PutMapping(value = "{id}")
    @Secured({Constants.ADM})
    public Categoria updateCategoria(@PathVariable("id") long id, @RequestBody Categoria categoria) throws ObjetoInexistenteException {

        Categoria currentCategoria = categoriaService.findById(id);

        if (currentCategoria == null) {
            throw new ObjetoInexistenteException("Unable to update. Produto with id " + id + " not found");
        }

        currentCategoria.setDesconto(categoria.getDesconto());
        currentCategoria.setNome(categoria.getNome());

        categoriaService.updateCategoria(currentCategoria);
        return currentCategoria;
    }
}
