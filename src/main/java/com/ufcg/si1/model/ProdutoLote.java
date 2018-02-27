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
    private Produto produto;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Lote> lotes;

    public ProdutoLote(Produto produto){
        this.produto = produto;
        this.lotes = new ArrayList<>();
    }
    public ProdutoLote(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoLote that = (ProdutoLote) o;
        return Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(produto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
