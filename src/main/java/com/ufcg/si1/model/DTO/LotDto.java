package com.ufcg.si1.model.DTO;

public class LotDto {

    private int itensAmount;
    private String expirationDate;

    public LotDto() {
    }

    public LotDto(int itensAmount, String expirationDate) {
        super();
        this.itensAmount = itensAmount;
        this.expirationDate = expirationDate;
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
