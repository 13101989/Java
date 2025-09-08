package com.example.spring_ch8_ex5.controllers;

import com.example.spring_ch8_ex5.models.Product;
import com.example.spring_ch8_ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model) {

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

//    @PostMapping("/products")
//    public String addProduct(
//            Product p,
//            Model model) {
//
//        productService.addProduct(p);
//
//        var products = productService.findAll();
//        model.addAttribute("products", products);
//
//        return "products.html";
//    }
}
