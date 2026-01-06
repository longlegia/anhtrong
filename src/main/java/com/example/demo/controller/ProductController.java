package com.example.demo.controller;

import com.example.demo.entities.Company;
import com.example.demo.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/company")
public class ProductController {
    ProductService ProductService;

    @GetMapping
    List<Company> getAllProducts() {
        List<Company> products = ProductService.getAllProducts();

        return products;
    }
}
