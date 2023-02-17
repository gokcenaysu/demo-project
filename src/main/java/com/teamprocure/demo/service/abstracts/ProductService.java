package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(Long id);
    public Product findByCode(Long code);
    public Product add(Product product);
    public Product update(Product product);
    public void delete(Long id);
}
