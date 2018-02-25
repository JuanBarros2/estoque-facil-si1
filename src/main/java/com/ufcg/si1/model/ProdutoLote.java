package com.ufcg.si1.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ProdutoLote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Produto produto;
    private List<Lote> lotes;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
