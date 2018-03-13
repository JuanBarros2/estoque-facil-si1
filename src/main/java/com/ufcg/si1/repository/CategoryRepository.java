package com.ufcg.si1.repository;

import com.ufcg.si1.model.Category;
import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
    List<Category> findAll();
}
