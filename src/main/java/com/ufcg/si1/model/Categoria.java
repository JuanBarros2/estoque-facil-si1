package com.ufcg.si1.model;

public class Categoria {
    private String nome;
    private double desconto;

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
}
