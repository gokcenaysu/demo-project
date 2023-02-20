package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.CategoryRepository;
import com.teamprocure.demo.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductServiceImpl productService;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByCode(Long code) {
        return categoryRepository.findByCode(code);
    }

    @Override
    public Category add(Category category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.getProducts()
                .addAll(category
                .getProducts()
                .stream()
                .map(p -> {
                    Product product = productService.findById(p.getId());
                    product.getCategories().add(newCategory);
                    return product;
                }).collect(Collectors.toList()));
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category update(Category category, Long id) {
        Category newCategory = categoryRepository.getReferenceById(id);
        newCategory.setName(category.getName());
        newCategory.setCode(category.getCode());
        category
                .getProducts()
                .stream()
                .map(p -> {
                    Product product = productService.findById(p.getId());
                    product.getCategories().add(newCategory);
                    return product;
                }).collect(Collectors.toList())
                .addAll(newCategory.getProducts());
        return categoryRepository.save(newCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteProductInCategory(Category category, Long id) {
        Category newCategory = categoryRepository.getReferenceById(id);
        category
                .getProducts()
                .stream()
                .map(p -> {
                    Product product = productService.findById(p.getId());
                    product.getCategories().remove(newCategory);
                    return product;
                }).collect(Collectors.toList())
                .remove(newCategory.getProducts());
         categoryRepository.save(newCategory);
    }
}
