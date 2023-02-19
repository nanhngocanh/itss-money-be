package com.hedspi.money.service;

import com.hedspi.money.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    BudgetRepository budgetRepository;

    public int getBudget(int userId, int categoryId) {
        Integer budget = budgetRepository.getBudget(userId, categoryId);
        return budget == null ? 0 : budget;
    }
}
