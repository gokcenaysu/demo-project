package com.teamprocure.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Field cannot be empty")
    @Column(name = "code")
    private Long code;

    @NotNull(message = "Field cannot be empty")
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private Collection<Product> products = new ArrayList<>();


}


