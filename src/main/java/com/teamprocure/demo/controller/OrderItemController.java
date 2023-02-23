package com.teamprocure.demo.controller;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;
import com.teamprocure.demo.service.abstracts.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-item")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;


    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
         orderItemService.delete(id);
    }
}
