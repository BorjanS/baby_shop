package com.baby_shop.baby_shop.repository;

import com.baby_shop.baby_shop.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}

