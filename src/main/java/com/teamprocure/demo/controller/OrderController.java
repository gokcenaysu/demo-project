package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.service.abstracts.OrderService;
import com.teamprocure.demo.service.concretes.OrderServiceImpl;
import com.teamprocure.demo.service.concretes.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

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

    @PutMapping("/update/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(order, id);
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam Long id){
        orderService.deleteOrder(id);
    }
}
