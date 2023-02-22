package com.hedspi.money.repository;

import com.hedspi.money.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    @Query("select w from Wallet w where w.userId = :userId")
    Wallet getWalletByUserId(Integer userId);
}
