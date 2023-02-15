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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name="name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="category_product",
              joinColumns = @JoinColumn(name = "product_id"),
              inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    private Collection<Category> categories = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    @JsonIgnore
    private Collection<Order> orders = new ArrayList<>();

}
