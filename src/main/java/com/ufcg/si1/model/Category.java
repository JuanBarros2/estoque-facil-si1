package com.ufcg.si1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    private double discount;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.discount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public Double applyDiscount(Double preco) {
        return Math.round((this.discount / 100) * preco * 100) / 100d;
    }
}
