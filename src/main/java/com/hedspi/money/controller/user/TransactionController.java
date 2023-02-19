package com.hedspi.money.controller.user;

import com.hedspi.money.entity.Transaction;
import com.hedspi.money.request.TransactionRequest;
import com.hedspi.money.service.BudgetService;
import com.hedspi.money.service.TransactionService;
import com.hedspi.money.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    BudgetService budgetService;

    @Autowired
    WalletService walletService;

    @GetMapping("/{user_id}/all")
    public ResponseEntity<Object> getAllTransaction(@PathVariable("user_id") int userId) {
        List<Transaction> transactions = transactionService.getAllTransaction(userId);
        Map<String, Object> data = new HashMap<>();
        data.put("transactions", transactions);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addTransaction(@RequestBody TransactionRequest transactionRequest) {
        transactionService.addTransaction(transactionRequest);
        int totalAmount = transactionService.getTotalAmount(transactionRequest.getUserId(),
                transactionRequest.getUserCategoryId());
        int budget = budgetService.getBudget(transactionRequest.getUserId(),
                transactionRequest.getUserCategoryId());

        walletService.updateAmount(transactionRequest.getWalletId(), transactionRequest.getType() * transactionRequest.getAmount());

        if (transactionRequest.getType() == -1 && budget > 0 && totalAmount > budget) {
            return ResponseEntity.ok("{\"message\": \"Vượt hạn mức\"}");
        }
        return ResponseEntity.ok("{\"message\": \"Thêm giao dịch thành công\"}");
    }

}
