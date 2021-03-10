package com.baby_shop.baby_shop.repository;

import com.baby_shop.baby_shop.model.Cart;
import com.baby_shop.baby_shop.model.enumerations.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUserUsernameAndStatus(String username, CartStatus status);
    boolean existsByUserUsernameAndStatus(String username, CartStatus status);
    List<Cart> findAllByUserUsername(String username);
}
