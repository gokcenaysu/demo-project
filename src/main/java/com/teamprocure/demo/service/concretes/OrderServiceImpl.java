package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.OrderItemRepository;
import com.teamprocure.demo.repository.OrderRepository;
import com.teamprocure.demo.service.abstracts.OrderItemService;
import com.teamprocure.demo.service.abstracts.OrderService;
import com.teamprocure.demo.service.abstracts.ProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderItemService orderItemService;

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
        order.setOrderItems(order.getOrderItems().stream()
                .map(o -> {
                    o.setOrder(order);
                    o.getProducts();
                    return o;
                }).collect(Collectors.toList()));
        orderItemService.calculatePrice(order);
        calculateTotalPrice(order);
        return orderRepository.save(order);
    }
    @Override
    public Order update(Order order, Long id) {
        order.setOrderItems(order.getOrderItems().stream()
                .map(o -> {
                    o.setOrder(order);
                    o.getProducts();
                    return o;
                }).collect(Collectors.toList()));
        orderItemService.calculatePrice(order);
        calculateTotalPrice(order);

        Optional<Order> byId = orderRepository.findById(id);

        Order update = byId.get();
        if(order.getOrderItems()!=null)
            update.setOrderItems(order.getOrderItems());

        return orderRepository.save(order);

    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void calculateTotalPrice(Order order) {
        order.setTotalPrice(order.getOrderItems().stream().mapToDouble(OrderItem::getPrice).sum());
    }
}
