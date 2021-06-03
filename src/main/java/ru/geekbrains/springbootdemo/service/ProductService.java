package ru.geekbrains.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootdemo.enities.Product;
import ru.geekbrains.springbootdemo.repositories.ProductJpaRepository;
import ru.geekbrains.springbootdemo.repositories.ProductsRepository;

import java.util.List;

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

    public List<Product> getProductsList() {
        return productsRepository.findAllByOrderByTitleAsc();
    }

    public void addProductToRepository(Product product) {
        productsRepository.addProductToList(product);
    }
}
