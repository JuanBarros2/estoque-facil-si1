package com.ufcg.si1.model.DTO;

import com.ufcg.si1.model.Category;
import com.ufcg.si1.model.Lot;
import com.ufcg.si1.model.Product;
import com.ufcg.si1.model.ProductLot;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDto implements Serializable {

    private Long id;

    private String name;

    private Double price;

    private String category;

    private String manufacturer;

    private Integer quantidade;


    public ProductDto(ProductLot productLot) {
        Product product = productLot.getProduct();
        Category category = product.getCategory();
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice() - category.applyDiscount(product.getPrice());
        this.manufacturer = product.getManufacturer();
        this.category = category.getName();
        this.quantidade = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for(Lot lot : productLot.getLots()){
            try {
                Date data = formato.parse(lot.getExpirationDate());
                if (data.after(new Date())){
                    this.quantidade += lot.getItensAmount();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }
}
