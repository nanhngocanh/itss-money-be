package com.hedspi.money.repository;

import com.hedspi.money.entity.Budget;
import com.hedspi.money.entity.Category;
import com.hedspi.money.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    //loi can sua
    @Query("select b from Budget b where b.userId = :userId")
    List<Budget> GetUserBudget(Integer userId);
    @Query("SELECT coalesce(MAX(b.id), 0) FROM Budget b")
    int GetMaxBudgetId();
    @Transactional
    @Modifying
    @Query(value = "Update budget set category_id = :category_id,amount = :amount, budget_time = :budget_time where id = :Id",nativeQuery = true)
    Integer UpdateBudget(Integer Id,Integer category_id,Integer amount,String budget_time);

}