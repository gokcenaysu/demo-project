package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.service.abstracts.ProductService;
import com.teamprocure.demo.service.concretes.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findByCode")
    public Product findById(@RequestParam Long productId){
        return productService.findById(productId);
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/update/{productId}")
    public Product update(@PathVariable Long productId, @RequestBody Product product) {
        product.setProductId(productId);
        return productService.update(product);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }
}
