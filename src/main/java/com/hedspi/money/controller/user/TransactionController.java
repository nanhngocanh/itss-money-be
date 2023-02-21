package com.hedspi.money.controller.user;

import com.hedspi.money.entity.Transaction;
import com.hedspi.money.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/{user_id}/all")
    public ResponseEntity<Object> getAllTransaction(@PathVariable("user_id") int userId) {
        List<Transaction> transactions = transactionService.getAllTransaction(userId);
        Map<String, Object> data = new HashMap<>();
        data.put("transactions", transactions);
        return ResponseEntity.ok(data);
    }
}
