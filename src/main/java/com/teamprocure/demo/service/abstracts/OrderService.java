package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAll();
    public Order findById(Long id);
    public Order add(Order order);
    public Order update(Order order, Long id);
    public void deleteOrder(Long id);
}
