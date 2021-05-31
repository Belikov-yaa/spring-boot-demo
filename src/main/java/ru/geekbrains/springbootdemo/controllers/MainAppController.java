package ru.geekbrains.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springbootdemo.enities.Product;
import ru.geekbrains.springbootdemo.service.ProductService;

import java.util.List;

@Controller
//@RequestMapping("/product")
public class MainAppController {
    private ProductService productsService;

    @Autowired
    public void setProductsService(ProductService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String showAllProducts(Model model) {
        List<Product> products = productsService.getProductsList();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/{id}")
    public String showProductById(Model model, @PathVariable(name = "id") int id) {
        Product product = productsService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/addProduct")
    public String showSimpleForm(Model uiModel) {
        uiModel.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productsService.addProductToRepository(product);
        return "redirect:/";
    }
}
