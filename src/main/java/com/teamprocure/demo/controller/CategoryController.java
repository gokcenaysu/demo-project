package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.service.abstracts.CategoryService;
import com.teamprocure.demo.service.concretes.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/findByCode")
    public Category findByCode(@RequestParam Long code) {
        return categoryService.findByCode(code);
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category) {
        return categoryService.add(category);
    }

    @PutMapping("/update/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(category, id);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProductInCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.deleteProductInCategory(category, id);
    }
}
