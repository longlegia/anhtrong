package com.example.demo.controller;

import com.example.demo.entities.Company;
import com.example.demo.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class ProductController {

    @Autowired
    ProductService ProductService;

    @GetMapping
    List<Company> getAllProducts() {
        List<Company> products = ProductService.getAllProducts();

        return products;
    }
}
