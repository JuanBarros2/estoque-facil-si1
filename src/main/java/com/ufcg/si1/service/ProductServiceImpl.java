package com.ufcg.si1.service;

import com.ufcg.si1.model.Category;
import com.ufcg.si1.model.Product;
import com.ufcg.si1.repository.ProductRepository;
import exceptions.ObjetoJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductLotService productLotService;

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product save(Product product) throws ObjetoJaExistenteException {
        if (this.exists(product)) {
            throw new ObjetoJaExistenteException("Produto já cadastrado");
        }

        this.addCategory(product);

        return productLotService.createFromProduct(product).getProduct();
    }

    @Override
    public Product get(Long id) {
        return productRepository.findOne(id);
    }

    private void addCategory(Product product) {
        Category category = categoryService.findByName(product.getCategory().getName());
        if (category == null) {
            category = new Category(product.getCategory().getName());
        }
        product.setCategory(category);
    }


    private boolean exists(Product product) {
        return productRepository.findByNameAndManufacturer(product.getName(), product.getManufacturer()) != null;
    }
}
