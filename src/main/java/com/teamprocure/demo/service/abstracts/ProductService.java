package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product findByCode(Long code);
    Product add(Product product);
    Product update(Product product, Long id);
    void delete(Long id);
}
