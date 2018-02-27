package com.ufcg.si1.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Categoria {
    @GeneratedValue
    @Id
    private Long id;
    private String nome;
    private double desconto;

    public Categoria(){
    }

    public Categoria(String nome){
        this.nome = nome;
        this.desconto = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
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
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nome);
    }

    public Double applyDiscount(Double preco) {
        return Math.round((this.desconto / 100) * preco * 100) / 100d;
    }
}
