package com.hedspi.money.repository;

import com.hedspi.money.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}