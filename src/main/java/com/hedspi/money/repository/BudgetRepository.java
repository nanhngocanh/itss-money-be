package com.hedspi.money.repository;

import com.hedspi.money.entity.Budget;
import com.hedspi.money.entity.Category;
import com.hedspi.money.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    @Query("select sum(b.amount) from Budget b where b.budgetTime like :budgetTime and b.userId = :userId")
    Integer getSumBudgetInMonth(Integer userId, String budgetTime);

    @Query("select sum(b.amount) from Budget b where b.budgetTime like :budgetTime and b.category.id = :categoryId and b.userId = :userId")
    Integer getSumBudgetInMonthByCategory(Integer userId, String budgetTime, Integer categoryId);
    @Query(value = """
                        select amount
                        from budget
                        where user_id = ?1 and category_id = ?2
                        and budget_time = date_format(now(), '%Y-%m');
            """,
            nativeQuery = true)
    Integer getBudget(int userId, int categoryId);
    //loi can sua
    @Query("select b from Budget b where b.userId = :userId order by b.budgetTime desc")
    List<Budget> GetUserBudget(Integer userId);
    @Query("SELECT coalesce(MAX(b.id), 0) FROM Budget b")
    int GetMaxBudgetId();
    @Transactional
    @Modifying
    @Query(value = "Update budget set category_id = :category_id,amount = :amount, budget_time = :budget_time where id = :Id",nativeQuery = true)
    Integer UpdateBudget(Integer Id,Integer category_id,Integer amount,String budget_time);

}