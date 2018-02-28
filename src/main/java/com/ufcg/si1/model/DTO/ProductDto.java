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

    private String name;

    private Double price;

    private String category;

    private String manufacturer;

    private Integer quantidade;


    public ProdutoDTO(ProdutoLote produtoLote) {
        Produto produto = produtoLote.getProduto();
        Categoria categoria = produto.getCategoria();
        this.id = produto.getId();
        this.name = produto.getNome();
        this.price = produto.getPreco() - categoria.applyDiscount(produto.getPreco());
        this.manufacturer = produto.getFabricante();
        this.category = categoria.getNome();
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
