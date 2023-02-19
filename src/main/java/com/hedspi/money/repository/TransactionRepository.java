package com.hedspi.money.repository;

import com.hedspi.money.entity.Transaction;
import com.hedspi.money.request.TransactionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t WHERE t.userId = ?1")
    List<Transaction> findAllByUserId(int userId);

    @Modifying
    @Transactional
    @Query(value = """
                        INSERT INTO transaction (user_id, wallet_id, user_category_id, type, amount, note, create_at)
                        VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)
            """,
            nativeQuery = true)
    void addTransaction(int userId, int walletId, int userCategoryId, int type, int amount, String note, String createAt);


    @Query(value = """
                        select sum(amount) as total_amount
                        from transaction
                        where user_id = 2 and user_category_id = 1
                        and date_format(create_at, '%Y-%m') = date_format(now(), '%Y-%m');
            """,
            nativeQuery = true)
    int getTotalAmount(int userId, int userCategoryId);

    @Modifying
    @Transactional
    @Query(value = """
                        UPDATE transaction
                        SET wallet_id = ?2, user_category_id = ?3, type = ?4, amount = ?5, note = ?6, create_at = ?7
                        WHERE id = ?1
            """,
            nativeQuery = true)
    void updateTransaction(Integer id, Integer walletId, Integer userCategoryId, Integer type, Integer amount, String note, String createAt);
}