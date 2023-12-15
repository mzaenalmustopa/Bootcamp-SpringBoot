package com.mzaaenalmustopa.springbootdasar.service;

import com.mzaaenalmustopa.springbootdasar.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Getter
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductService(ProductRepository repository, String name) {
        this.repository = repository;
    }
}
