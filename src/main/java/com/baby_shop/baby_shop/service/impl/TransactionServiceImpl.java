package com.baby_shop.baby_shop.service.impl;

import com.baby_shop.baby_shop.model.Transaction;
import com.baby_shop.baby_shop.repository.TransactionRepository;
import com.baby_shop.baby_shop.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void saveTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }
}

