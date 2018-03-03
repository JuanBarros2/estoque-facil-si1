package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lot {

    @Id
    @GeneratedValue
    private long id;

    private int itensAmount;

    private String expirationDate;

    public Lot() {
        this.id = 0;
    }

    public Lot(int itensAmount, String dataDeValidade) {
        super();
        this.itensAmount = itensAmount;
        this.expirationDate = dataDeValidade;
    }

    public Lot(long id, int itensAmount, String dataDeValidade) {
        this.id = id;
        this.itensAmount = itensAmount;
        this.expirationDate = dataDeValidade;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
