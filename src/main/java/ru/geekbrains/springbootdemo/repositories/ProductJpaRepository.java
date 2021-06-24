package ru.geekbrains.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springbootdemo.entities.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

    Product findProductById(Long id);

    Page<Product> findAllByOrderByTitleAsc(Pageable pageable);

    Page<Product> findAllByPriceAfterOrderByTitleAsc(Pageable pageable, int min);

    Page<Product> findAllByPriceBeforeOrderByTitleAsc(Pageable pageable, int max);

    Page<Product> findAllByPriceBetweenOrderByTitleAsc(Pageable pageable, int min, int max);

}
