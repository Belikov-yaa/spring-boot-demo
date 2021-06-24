package ru.geekbrains.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootdemo.entities.Product;
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

    public Product getProductById(Long id) {
        return productsRepository.findProductById(id);
    }

    public Page<Product> getProductsList(Pageable pageable, Integer min, Integer max) {
        if (min != null && max != null && min <= max)
            return productsRepository.findAllByPriceBetweenOrderByTitleAsc(pageable, min, max);
        else if (min == null && max != null && max > 0)
            return productsRepository.findAllByPriceBeforeOrderByTitleAsc(pageable, max);
        else if (max == null && min != null && min > 0)
            return productsRepository.findAllByPriceAfterOrderByTitleAsc(pageable, min);
        else
            return productsRepository.findAllByOrderByTitleAsc(pageable);
    }

    public void addProductToRepository(Product product) {
        productsRepository.saveAndFlush(product);
    }
}
