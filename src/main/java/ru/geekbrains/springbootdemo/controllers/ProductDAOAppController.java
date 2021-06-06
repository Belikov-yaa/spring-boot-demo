package ru.geekbrains.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springbootdemo.dao.ProductsDAO;
import ru.geekbrains.springbootdemo.enities.Product;
import ru.geekbrains.springbootdemo.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/dao")
public class ProductDAOAppController {
    private final ProductsDAO productsDAO;

    public ProductDAOAppController(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @GetMapping("")
    public String showAllProducts(Model model) {
        List<Product> products = productsDAO.findAll();
        model.addAttribute("products", products);
        return "dao/index";
    }

    @GetMapping("/{id}")
    public String showProductById(Model model, @PathVariable(name = "id") Long id) {
        Product product = productsDAO.findById(id);
        model.addAttribute("product", product);
        return "dao/product";
    }

    @RequestMapping("/addProduct")
    public String showSimpleForm(Model model) {
        model.addAttribute("product", new Product());
        return "dao/product-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productsDAO.save(product);
        return "redirect:/dao";
    }
}
