package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lote {

    @Id
    @GeneratedValue
    private long id;

    private int itensAmount;
    private String dataDeValidade;

    public Lote() {
        this.id = 0;
    }

    public Lote(int itensAmount, String dataDeValidade) {
        super();
        this.itensAmount = itensAmount;
        this.dataDeValidade = dataDeValidade;
    }

    public Lote(long id, int itensAmount, String dataDeValidade) {
        this.id = id;
        this.itensAmount = itensAmount;
        this.dataDeValidade = dataDeValidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getItensAmount() {
        return itensAmount;
    }

    public void setItensAmount(int itensAmount) {
        this.itensAmount = itensAmount;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", itensAmount=" + itensAmount +
                ", dataDeValidade='" + dataDeValidade + '\'' +
                '}';
    }
}
