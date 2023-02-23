package com.teamprocure.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantity")
    private Long quantity;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "price")
    private double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull(message = "Field cannot be empty")
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="order_items_products",
            joinColumns = @JoinColumn(name = "order_item_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Collection<Product> products = new ArrayList<>();

}
