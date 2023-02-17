package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();
    public Category findByCode(Long code);
    public Category add(Category category);
    public Category update(Category category, Long id);
    public void deleteCategory(Long id);
    public void deleteProductInCategory(Category category, Long id);
}
