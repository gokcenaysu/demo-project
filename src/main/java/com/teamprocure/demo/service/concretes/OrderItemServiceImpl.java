package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.OrderItemRepository;
import com.teamprocure.demo.repository.OrderRepository;
import com.teamprocure.demo.service.abstracts.OrderItemService;
import com.teamprocure.demo.service.abstracts.ProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public void calculatePrice(Order order) {
        order.getOrderItems().forEach(orderItem -> orderItem.setPrice(orderItem.getUnitPrice()*orderItem.getQuantity()));
    }


}

