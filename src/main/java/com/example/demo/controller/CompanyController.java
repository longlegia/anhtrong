package com.example.demo.controller;

import com.example.demo.dtos.response.CompanyResponse;
import com.example.demo.entities.Company;
import com.example.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    List<CompanyResponse> getAllProducts() {
        List<Company> companies = companyService.getCompanies();
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for(Company company : companies) {
            CompanyResponse x = new CompanyResponse();
            x.setId(company.getId());
            x.setName(company.getName());
            companyResponses.add(x);
        }

        return companyResponses;
    }
}
