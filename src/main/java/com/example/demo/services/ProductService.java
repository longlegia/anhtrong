package com.example.demo.services;

import com.example.demo.entities.Company;
import com.example.demo.repositories.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Company> getAllProducts() {
        List<Company> products = productRepository.findAll();
        System.out.println(products);

        return products;
    }
}
