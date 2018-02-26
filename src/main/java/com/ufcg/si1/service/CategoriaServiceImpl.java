package com.ufcg.si1.service;

import com.ufcg.si1.model.Categoria;
import com.ufcg.si1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAllCategoria() {
        List<Categoria> lista = new ArrayList<>();
        Iterable<Categoria> iterable = categoriaRepository.findAll();
        iterable.forEach(lista::add);
        return lista;
    }

    @Override
    public Categoria findById(long id) {
        return categoriaRepository.findOne(id);
    }

    @Override
    public long size() {
        return categoriaRepository.count();
    }

    @Override
    public void updateCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Iterator<Categoria> getIterator() {
        Iterable<Categoria> iterable = categoriaRepository.findAll();
        return iterable.iterator();
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
