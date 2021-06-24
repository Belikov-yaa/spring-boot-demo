package ru.geekbrains.springbootdemo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springbootdemo.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
