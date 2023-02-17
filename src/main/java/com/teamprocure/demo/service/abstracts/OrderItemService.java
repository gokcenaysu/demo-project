package com.teamprocure.demo.service.abstracts;

import com.teamprocure.demo.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    public List<OrderItem> findAll();
    public OrderItem findById(Long id);
    public OrderItem add(OrderItem orderItem);
    public OrderItem update(OrderItem orderItem, Long id);
    public void deleteOrderItem(Long id);
    public void deleteProductInOrderItem(OrderItem orderItem, Long id);
}
