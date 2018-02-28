package com.ufcg.si1.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProdutoLote {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Product Product;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Lote> lotes;

    public ProdutoLote(Product Product){
        this.Product = Product;
        this.lotes = new ArrayList<>();
    }
    public ProdutoLote(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoLote that = (ProdutoLote) o;
        return Objects.equals(Product, that.Product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product Product) {
        this.Product = Product;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void adicionarLote(Lote lote) {
        if(lote != null){
            this.lotes.add(lote);
        }
    }
}
