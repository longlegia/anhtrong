package com.example.demo.services;

import com.example.demo.entities.Company;
import com.example.demo.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        List<Company> companies = companyRepository.findAll();

        return companies;
    }
}
