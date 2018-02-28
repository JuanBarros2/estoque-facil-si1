package com.ufcg.si1.service;

import com.ufcg.si1.model.Category;

import java.util.Iterator;
import java.util.List;

public interface CategoryService {
    List<Category> findAllCategoria();

    Category findById(long id);

    long size();

    void updateCategoria(Category category);

    Iterator<Category> getIterator();

    Category saveCategoria(Category category);
}
