package com.ufcg.si1.service;

import com.ufcg.si1.model.Category;

import java.util.Iterator;
import java.util.List;

public interface CategoryService {
    Category findByName(String name);
    Category update(Category category);
    List<Category> findAll();
}
