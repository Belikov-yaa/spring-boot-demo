package ru.geekbrains.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.springbootdemo.entities.User;
import ru.geekbrains.springbootdemo.service.OrderService;
import ru.geekbrains.springbootdemo.service.UserService;
import ru.geekbrains.springbootdemo.utils.ShoppingCart;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCart cart;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("items", cart.getItems());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        return "redirect:/shop";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        orderService.createOrderFromItems(user, cart.getItems());
        return "redirect:/shop";
    }
}
