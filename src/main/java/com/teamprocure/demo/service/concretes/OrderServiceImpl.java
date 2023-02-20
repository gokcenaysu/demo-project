package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.OrderRepository;
import com.teamprocure.demo.service.abstracts.OrderItemService;
import com.teamprocure.demo.service.abstracts.OrderService;
import com.teamprocure.demo.service.abstracts.ProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order add(Order order) {
        Order newOrder = new Order();
        newOrder.setTotalPrice(order.getTotalPrice());
        return orderRepository.save(newOrder);
    }
    @Override
    public Order update(Order order, Long id) {
        order.setId(id);
        return orderRepository.save(order);    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
