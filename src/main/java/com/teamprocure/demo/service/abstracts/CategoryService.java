package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();
    public Category findById(Long categoryId);
    public Category add(Category category);
    public Category update(Category category);
    public void delete(Long id);
}
