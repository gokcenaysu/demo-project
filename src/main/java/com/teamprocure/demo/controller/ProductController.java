package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.service.abstracts.ProductService;
import com.teamprocure.demo.service.concretes.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByCode")
    public ResponseEntity<Product> findByCode(@RequestParam Long code){
        return new ResponseEntity<>(productService.findByCode(code), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody @Valid Product product){
        return new ResponseEntity<>(productService.add(product), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return new ResponseEntity<>(productService.update(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }
}
