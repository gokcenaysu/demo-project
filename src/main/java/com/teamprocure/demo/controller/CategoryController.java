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
    private CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/findByCode")
    public Category findById (@RequestParam Long categoryId){
        return categoryService.findById(categoryId);
    }

    @PostMapping("/add")
    public Category add (@RequestBody Category category){
        return categoryService.add(category);
    }

    @PutMapping("/update")
    public Category update (@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam Long id){
        categoryService.delete(id);
    }


}
