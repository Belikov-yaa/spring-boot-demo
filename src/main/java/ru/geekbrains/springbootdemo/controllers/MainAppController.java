package ru.geekbrains.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.springbootdemo.enities.Product;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class MainAppController {

    @GetMapping("")
    public String showAllProducts(Model model) {
//        List<Product> products = productsService.getProductsList();
        Product product = new Product(1, "Potato", 3.40);
        model.addAttribute("products", product);
        return "index";
    }

    @GetMapping("/{id}")
    public String showProductById(Model model, @PathVariable(name = "id") int id) {
//        Product product = productsService.getProductById(id);
        Product product = new Product(id, "Potato", 3.40);
        model.addAttribute("product", product);
        return "product";
    }
}
