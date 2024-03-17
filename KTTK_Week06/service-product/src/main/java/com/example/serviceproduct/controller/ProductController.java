package com.example.serviceproduct.controller;

import com.example.serviceproduct.model.Product;
import com.example.serviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/get-all-product")
    public List<Product> getAll(){
        return service.getAllProduct();
    }
}
