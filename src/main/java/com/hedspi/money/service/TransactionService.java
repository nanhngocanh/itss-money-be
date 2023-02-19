package com.hedspi.money.service;

import com.hedspi.money.entity.Transaction;
import com.hedspi.money.repository.TransactionRepository;
import com.hedspi.money.request.TransactionRequest;
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

    public void addTransaction(TransactionRequest tr) {
        transactionRepository.addTransaction(tr.getUserId(), tr.getWalletId(), tr.getUserCategoryId(),
                tr.getType(), tr.getAmount(), tr.getNote(), tr.getCreateAt());
    }

    public int getTotalAmount(int userId, int userCategoryId) {
        return transactionRepository.getTotalAmount(userId, userCategoryId);
    }
}
