package com.ufcg.si1.service;

import com.ufcg.si1.model.Categoria;

import java.util.Iterator;
import java.util.List;

public interface CategoriaService {
    List<Categoria> findAllCategoria();

    Categoria findById(long id);

    long size();

    void updateCategoria(Categoria categoria);

    Iterator<Categoria> getIterator();

    Categoria saveCategoria(Categoria categoria);
}
