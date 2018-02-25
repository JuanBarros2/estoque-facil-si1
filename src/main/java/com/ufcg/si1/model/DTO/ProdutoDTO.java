package com.ufcg.si1.model.DTO;

import com.ufcg.si1.model.Categoria;
import com.ufcg.si1.model.Lote;
import com.ufcg.si1.model.Produto;
import com.ufcg.si1.model.ProdutoLote;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoDTO {

    private String nome;

    private Double preco;

    private String categoria;

    private String fabricante;

    private Integer quantidade;


    public ProdutoDTO(ProdutoLote produtoLote) {
        Produto produto = produtoLote.getProduto();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.fabricante = produto.getFabricante();
        Categoria categoria = produto.getCategoria();
        this.categoria = categoria.getNome();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        for(Lote lote : produtoLote.getLotes()){
            try {
                Date data = formato.parse(lote.getDataDeValidade());
                if (data.before(new Date())){
                    this.quantidade += lote.getNumeroDeItens();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
