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

    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id).isPresent() ? transactionRepository.findById(id).get() : null;
    }

    public void deleteTransaction(int transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public void updateTransaction(TransactionRequest transactionRequest) {
        transactionRepository.updateTransaction(transactionRequest.getId(), transactionRequest.getWalletId(),
                transactionRequest.getUserCategoryId(), transactionRequest.getType(), transactionRequest.getAmount(),
                transactionRequest.getNote(), transactionRequest.getCreateAt());
    }
}
