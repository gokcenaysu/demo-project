package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.service.abstracts.CategoryService;
import com.teamprocure.demo.service.concretes.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByCode")
    public ResponseEntity<Category> findByCode(@RequestParam Long code) {
        return new ResponseEntity<>(categoryService.findByCode(code), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.add(category), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return new ResponseEntity<>(categoryService.update(category, id), HttpStatus.OK);
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
