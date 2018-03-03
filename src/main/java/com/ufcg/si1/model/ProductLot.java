package com.ufcg.si1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProductLot {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(unique = true)
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Lot> lots;

    public ProductLot(Product Product) {
        this.product = Product;
        this.lots = new ArrayList<>();
    }

    public ProductLot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLot that = (ProductLot) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product Product) {
        this.product = Product;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void addLot(Lot lot) {
        if (lot != null) {
            this.lots.add(lot);
        }
    }
}
