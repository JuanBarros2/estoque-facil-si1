package com.ufcg.si1.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Produto;
import com.ufcg.si1.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {


	@Autowired
	private ProdutoRepository produtoRepository;


	public Set<Produto> findAllProdutos() {
		Iterable<Produto> it = produtoRepository.findAll();
		Set<Produto> produtos = new HashSet<>();
		it.forEach(produtos::add);
		return produtos;
	}

	@Override
	public void saveProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public Produto findById(long id) {
		return produtoRepository.findOne(id);
	}

	@Override
	public void updateProduto(Produto user) {
		produtoRepository.save(user);
	}

	@Override
	public void deleteProdutoById(long id) {
		produtoRepository.delete(id);
	}

	@Override
	public int size() {
		return produtoRepository.countAllById();
	}

	@Override
	public Iterator<Produto> getIterator() {
		Iterable<Produto> iterable = produtoRepository.findAll();
		return iterable.iterator();
	}

	@Override
	public boolean doesProdutoExist(Produto produto) {
		return produtoRepository.exists(produto.getId());
	}

}
