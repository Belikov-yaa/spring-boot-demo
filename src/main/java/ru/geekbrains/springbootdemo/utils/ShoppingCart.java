package ru.geekbrains.springbootdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.geekbrains.springbootdemo.entities.OrderItem;
import ru.geekbrains.springbootdemo.entities.Product;
import ru.geekbrains.springbootdemo.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<OrderItem> items;

    private ProductService productService;
    private int totalCost;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void addProductById(Long id) {
        Product product = productService.getProductById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        items.add(orderItem);
    }

    public void add(Product product) {
        OrderItem orderItem = findOrderFromProduct(product);
        if (orderItem == null) {
            orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setItemPrice(product.getPrice());
            orderItem.setQuantity(0);
            orderItem.setId(0L);
            items.add(orderItem);
        }
        orderItem.setQuantity(orderItem.getQuantity() + 1);
    }

    public void remove(Product product) {
        OrderItem orderItem = findOrderFromProduct(product);
        if (orderItem == null) {
            return;
        }
        items.remove(orderItem);
    }

    private void recalculate() {
        totalCost = 0;
        for (OrderItem o : items) {
            o.setTotalPrice(o.getQuantity() * o.getProduct().getPrice());
            totalCost += o.getTotalPrice();
        }
    }
    private OrderItem findOrderFromProduct(Product product) {
        return items.stream()
                .filter(o -> o.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);
    }
}
