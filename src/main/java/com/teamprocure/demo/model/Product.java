package com.teamprocure.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private Long code;

    @Column(name="name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="categories_products",
              joinColumns = @JoinColumn(name = "product_id"),
              inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    private Collection<Category> categories = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.REMOVE, mappedBy = "products")
    @JsonIgnore
    private Collection<OrderItem> orderItems = new ArrayList<>();

    public Collection<OrderItem> getOrderItems(){
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems){
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
    }
}
