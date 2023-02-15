package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.service.concretes.OrderServiceImpl;
import com.teamprocure.demo.service.concretes.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/findByCode")
    public Order findById(@RequestParam Long orderId){
        return orderService.findById(orderId);
    }

    @PostMapping("/add")
    public Order add(@RequestBody Order order){
        return orderService.add(order);
    }

    @PutMapping("/update/{orderId}")
    public Order update(@PathVariable Long orderId, @RequestBody Order order) {
        order.setOrderId(orderId);
        return orderService.update(order);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        orderService.delete(id);
    }
}
