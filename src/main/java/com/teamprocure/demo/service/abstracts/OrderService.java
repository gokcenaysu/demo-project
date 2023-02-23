package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;

import java.util.List;

public interface OrderService {

     List<Order> findAll();
     Order findById(Long id);
     Order add(Order order);
     Order update(Order order, Long id);
     void deleteOrder(Long id);
}
