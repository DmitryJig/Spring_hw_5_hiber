package com.example.hw5_hiber1_h2.controllers;

import com.example.hw5_hiber1_h2.model.Product;
import com.example.hw5_hiber1_h2.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> showAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Product addProduct(@ModelAttribute Product newProduct){
        return productService.saveOrUpdate(newProduct);
    }
}
