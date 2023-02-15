package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.OrderRepository;
import com.teamprocure.demo.service.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public Order add(Order order) {
        Order newOrder = new Order();
        newOrder.getProducts()
                .addAll(order
                        .getProducts()
                        .stream()
                        .map(p -> {
                            Product product = productService.findById(p.getProductId());
                            product.getOrders().add(newOrder);
                            return product;
                        }).collect(Collectors.toList()));
        return orderRepository.save(newOrder);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
