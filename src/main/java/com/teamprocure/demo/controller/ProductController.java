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
    private ProductService productService;

    @GetMapping("/findAll")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/findByCode")
    public Product findByCode(@RequestParam Long code){
        return productService.findByCode(code);
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.update(product, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }
}
