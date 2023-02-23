package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    void delete(Long id);
    void calculatePrice(Order order);

}
