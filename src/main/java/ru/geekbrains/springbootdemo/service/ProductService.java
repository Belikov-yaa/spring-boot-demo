package ru.geekbrains.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootdemo.enities.Product;
import ru.geekbrains.springbootdemo.repositories.ProductJpaRepository;

@Service
public class ProductService {
//    private ProductsRepository productsRepository;
    private ProductJpaRepository productsRepository;


    @Autowired
    public void setProductsRepository(ProductJpaRepository productsJpaRepository) {
        this.productsRepository = productsJpaRepository;
    }

    public ProductService() {
    }

    public Product getProductById(int id) {
        return productsRepository.findProductById(id);
    }

    public Page<Product> getProductsList(Pageable pageable) {
        return productsRepository.findAllByOrderByTitleAsc(pageable);
    }

    public void addProductToRepository(Product product) {
        productsRepository.saveAndFlush(product);
    }
}
