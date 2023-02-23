package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.CategoryRepository;
import com.teamprocure.demo.repository.ProductRepository;
import com.teamprocure.demo.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product findByCode(Long code) {
       return productRepository.findByCode(code);
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id){

        Optional<Product> byId = productRepository.findById(id);
        if(!byId.isPresent())
            return null;

        Product update = byId.get();
        if(!(product.getCode()==null)){
            update.setCode(product.getCode());
       }
        if(!(product.getName()==null)){
            update.setName(product.getName());
        }
        return productRepository.save(update);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
