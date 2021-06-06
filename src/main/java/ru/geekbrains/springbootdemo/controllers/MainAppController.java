package ru.geekbrains.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springbootdemo.enities.Product;
import ru.geekbrains.springbootdemo.service.ProductService;

@Controller
//@RequestMapping("/product")
public class MainAppController {
    private ProductService productsService;

    @Autowired
    public void setProductsService(ProductService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String showAllProducts(
            Model model,
            @RequestParam(name = "min", required = false) Integer min,
            @RequestParam(name = "max", required = false) Integer max,
            @PageableDefault(sort = {"title"}, size = 5, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Product> products = productsService.getProductsList(pageable, min, max);
        PageWrapper<Product> page = new PageWrapper<>(products, "/");
        model.addAttribute("products", products.getContent());
        model.addAttribute("page", page);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "index";
    }

    @GetMapping("/{id}")
    public String showProductById(Model model, @PathVariable(name = "id") int id) {
        Product product = productsService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping("/addProduct")
    public String showSimpleForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productsService.addProductToRepository(product);
        return "redirect:/";
    }
}
