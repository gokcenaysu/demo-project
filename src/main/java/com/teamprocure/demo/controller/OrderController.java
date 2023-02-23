package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.service.abstracts.OrderService;
import com.teamprocure.demo.service.concretes.OrderServiceImpl;
import com.teamprocure.demo.service.concretes.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByCode")
    public ResponseEntity<Order> findById(@RequestParam Long orderId){
        return new ResponseEntity(orderService.findById(orderId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> add(@RequestBody Order order){
        return new ResponseEntity<>(orderService.add(order), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return new ResponseEntity<>(orderService.update(order, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam Long id){
        orderService.deleteOrder(id);
    }
}
