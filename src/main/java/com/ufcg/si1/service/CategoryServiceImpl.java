package com.ufcg.si1.service;

import com.ufcg.si1.model.Category;
import com.ufcg.si1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategoria() {
        List<Category> lista = new ArrayList<>();
        Iterable<Category> iterable = categoryRepository.findAll();
        iterable.forEach(lista::add);
        return lista;
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public long size() {
        return categoryRepository.count();
    }

    @Override
    public void updateCategoria(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Iterator<Category> getIterator() {
        Iterable<Category> iterable = categoryRepository.findAll();
        return iterable.iterator();
    }

    @Override
    public Category saveCategoria(Category category) {
        return categoryRepository.save(category);
    }
}
