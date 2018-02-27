package com.ufcg.si1.model.DTO;

import com.ufcg.si1.model.Categoria;
import com.ufcg.si1.model.Lote;
import com.ufcg.si1.model.Produto;
import com.ufcg.si1.model.ProdutoLote;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoDTO implements Serializable {

    private Long id;

    private String nome;

    private Double preco;

    private String categoria;

    private String fabricante;

    private Integer quantidade;


    public ProdutoDTO(ProdutoLote produtoLote) {
        Produto produto = produtoLote.getProduto();
        Categoria categoria = produto.getCategoria();
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco() - categoria.applyDiscount(produto.getPreco());
        this.fabricante = produto.getFabricante();
        this.categoria = categoria.getNome();
        this.quantidade = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for(Lote lote : produtoLote.getLotes()){
            try {
                Date data = formato.parse(lote.getDataDeValidade());
                if (data.after(new Date())){
                    this.quantidade += lote.getNumeroDeItens();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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
