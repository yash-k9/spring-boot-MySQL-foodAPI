package com.devX.app.foodService.repository;

import com.devX.app.foodService.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FoodRepository extends JpaRepository<Item, Integer> {
    Long deleteByName(String firstName);

    @Query(value = "select u from Item u where u.category = ?1")
    List<Item> findByCategory(String name);
}
