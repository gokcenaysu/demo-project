package com.teamprocure.demo.repository;

import com.teamprocure.demo.model.Category;
import com.teamprocure.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCode(Long code);

}
