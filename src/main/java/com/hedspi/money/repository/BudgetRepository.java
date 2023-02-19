package com.hedspi.money.repository;

import com.hedspi.money.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    @Query(value = """
                        select amount
                        from budget
                        where user_id = ?1 and category_id = ?2
                        and budget_time = date_format(now(), '%Y-%m');
            """,
            nativeQuery = true)
    Integer getBudget(int userId, int categoryId);
}