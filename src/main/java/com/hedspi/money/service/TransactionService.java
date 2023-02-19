package com.hedspi.money.service;

import com.hedspi.money.entity.Transaction;
import com.hedspi.money.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction(int userId) {
        return transactionRepository.findAllByUserId(userId);
    }
}
