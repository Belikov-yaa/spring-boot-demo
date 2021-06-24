package ru.geekbrains.springbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @GetMapping("/")
    public String indexPage() {
        return "Authtority Zone";
    }

}
