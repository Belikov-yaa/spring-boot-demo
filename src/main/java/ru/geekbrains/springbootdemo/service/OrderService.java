package ru.geekbrains.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootdemo.entities.Order;
import ru.geekbrains.springbootdemo.entities.OrderItem;
import ru.geekbrains.springbootdemo.entities.User;
import ru.geekbrains.springbootdemo.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrderFromItems(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setItems(new ArrayList<>());
        order.setUser(user);
        items.stream().forEach(item -> {
            order.getItems().add(item);
            item.setOrder(order);
        });
        items.clear();
        return orderRepository.save(order);
    }
}
