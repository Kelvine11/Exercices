package org.example.exercices.Exercice2.controller;

import org.example.exercices.Exercice2.entity.Product;
import org.example.exercices.Exercice2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "exercice2/products";
    }

    @GetMapping("product/{id}")
    public String product(@PathVariable UUID id, Model model) {
        System.out.println(productService.getProductById(id));
        model.addAttribute("product", productService.getProductById(id));
        return "exercice2/details";
    }

    @GetMapping("productSearch")
    public String productSearch(@RequestParam("category") String category, @RequestParam("price") double price, Model model){
        List<Product> products = productService.getProductByCategoryAndPriceMax(category, price);
        System.out.println(products);
        System.out.println(category);
        System.out.println(price);
        model.addAttribute("products", products);
        return "exercice2/products";
    }

}
