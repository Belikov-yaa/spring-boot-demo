package ru.geekbrains.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootdemo.enities.Product;
import ru.geekbrains.springbootdemo.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductService() {
    }

    public Product getProductById(int id) {
        return productsRepository.getProductByID(id);
    }

    public List<Product> getProductsList() {
        return productsRepository.getProducts();
    }

    public void addProductToRepository(Product product) {
        productsRepository.addProductToList(product);
    }
}
