package com.baby_shop.baby_shop.repository;

import com.baby_shop.baby_shop.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {


}
