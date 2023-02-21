package com.hedspi.money.repository;

import com.hedspi.money.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT SUM(amount) FROM transaction WHERE user_id = :userId AND DAY(create_at) = :day AND MONTH(create_at) = :month AND YEAR(create_at) = :year AND TYPE = :type",nativeQuery = true)
    Integer getSumTransactionOfDayByType(Integer userId, Integer year, Integer month, Integer day, Integer type);

    @Query(value = "SELECT SUM(amount) FROM transaction WHERE user_id = :userId AND DAY(create_at) = :day AND MONTH(create_at) = :month AND YEAR(create_at) = :year AND TYPE = :type AND user_category_id = :categoryId",nativeQuery = true)
    Integer getSumTransactionOfDayByTypeAndCategory(Integer userId, Integer year, Integer month, Integer day, Integer type, Integer categoryId);

    @Query(value = "SELECT SUM(amount) FROM transaction WHERE user_id = :userId AND MONTH(create_at) = :month AND YEAR(create_at) = :year AND TYPE = :type",nativeQuery = true)
    Integer getSumTransactionOfMonthByType(Integer userId, Integer year, Integer month, Integer type);

    @Query(value = "SELECT SUM(amount) FROM transaction WHERE user_id = :userId AND MONTH(create_at) = :month AND YEAR(create_at) = :year AND TYPE = :type AND user_category_id = :categoryId",nativeQuery = true)
    Integer getSumTransactionOfMonthByTypeAndCategory(Integer userId, Integer year, Integer month, Integer type, Integer categoryId);



}