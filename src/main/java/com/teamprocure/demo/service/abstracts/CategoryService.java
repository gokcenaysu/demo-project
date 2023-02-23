package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category findByCode(Long code);
    Category add(Category category);
    Category update(Category category, Long id);
    void deleteCategory(Long id);
    void deleteProductInCategory(Category category, Long id);
}
