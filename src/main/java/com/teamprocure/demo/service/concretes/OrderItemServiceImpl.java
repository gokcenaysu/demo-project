package com.teamprocure.demo.service.concretes;

import com.teamprocure.demo.model.Order;
import com.teamprocure.demo.model.OrderItem;
import com.teamprocure.demo.model.Product;
import com.teamprocure.demo.repository.OrderItemRepository;
import com.teamprocure.demo.repository.OrderRepository;
import com.teamprocure.demo.repository.ProductRepository;
import com.teamprocure.demo.service.abstracts.OrderItemService;
import com.teamprocure.demo.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findById(Long id) {
        return null;
    }

    @Override
    public OrderItem add(OrderItem orderItem) {
        OrderItem newOrderItem = new OrderItem();
        newOrderItem.setUnitPrice(orderItem.getUnitPrice());
        newOrderItem.setPrice(orderItem.getPrice());
        newOrderItem.setQuantity(orderItem.getQuantity());
        newOrderItem.setProducts(orderItem
                .getProducts()
                .stream()
                .map(p -> {
                            Product product = productService.findById(p.getId());
                            product.addOrderItem(newOrderItem);
                            return product;
                })
                .collect(Collectors.toList()));
        return orderItemRepository.save(newOrderItem);
    }

    @Override
    public OrderItem update(OrderItem orderItem, Long id) {
        OrderItem newOrderItem = orderItemRepository.getReferenceById(id);
        newOrderItem.getProducts()
                .addAll(orderItem
                        .getProducts()
                        .stream()
                        .map(p -> {
                            Product product = productService.findById(p.getId());
                            product.getOrderItems().add(newOrderItem);
                            return product;
                        }).collect(Collectors.toList()));
        return orderItemRepository.save(newOrderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public void deleteProductInOrderItem(OrderItem orderItem, Long id) {
        OrderItem newOrderItem = orderItemRepository.getReferenceById(id);
        newOrderItem.getProducts()
                .remove(orderItem
                        .getProducts()
                        .stream()
                        .map(p -> {
                            Product product = productService.findById(p.getId());
                            product.getOrderItems().remove(newOrderItem);
                            return product;
                        }).collect(Collectors.toList()));
         orderItemRepository.save(newOrderItem);
    }
}
