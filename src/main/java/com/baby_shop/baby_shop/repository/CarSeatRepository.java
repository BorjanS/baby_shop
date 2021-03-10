package com.baby_shop.baby_shop.repository;

import com.baby_shop.baby_shop.model.Car_seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarSeatRepository extends JpaRepository<Car_seat, Integer> {

}
