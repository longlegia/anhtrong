package com.example.demo.services;

import com.example.demo.entities.Company;
import com.example.demo.repositories.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;

    public List<Company> getAllProducts() {
        List<Company> products = productRepository.findAll();
        System.out.println(products);

        return products;
    }
}
