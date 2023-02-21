package com.hedspi.money.service;

import com.hedspi.money.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import com.hedspi.money.entity.Budget;
import com.hedspi.money.repository.CategoryRepository;
import com.hedspi.money.request.createResquest.CreateBudgetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class BudgetService {
    @Autowired
    BudgetRepository budgetRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public int getBudget(int userId, int categoryId) {
        Integer budget = budgetRepository.getBudget(userId, categoryId);
        return budget == null ? 0 : budget;
    }

    public Budget CreateBudget(CreateBudgetRequest createBudgetRequest) {
        Budget budget = new Budget();
        budget.setAmount(createBudgetRequest.getAmount());
        budget.setCategory(categoryRepository.findById(createBudgetRequest.getCategoryId()).get());
        budget.setUserId(createBudgetRequest.getUserId());
        budget.setBudgetTime(createBudgetRequest.getBudgetTime());
        budget.setCreateAt(Instant.now());
        budget.setUpdateAt(Instant.now());

        return budgetRepository.save(budget);
    }
    public Integer UpdateBudget(Integer Id, CreateBudgetRequest createBudgetRequest) {
        return budgetRepository.UpdateBudget(Id, createBudgetRequest.getCategoryId(), createBudgetRequest.getAmount(), createBudgetRequest.getBudgetTime() );
    }
    public void DeleteBudget(Integer Id) {
        Budget budget = budgetRepository.findById(Id).get();
        budgetRepository.delete(budget);
    }
    //loi can sua
    public List<Budget> GetUserBudget(Integer userId) {
        return budgetRepository.GetUserBudget(userId);
    }
}
