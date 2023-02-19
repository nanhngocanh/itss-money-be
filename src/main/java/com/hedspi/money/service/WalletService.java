package com.hedspi.money.service;

import com.hedspi.money.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;

    public void updateAmount(int walletId, int amount) {
        walletRepository.findById(walletId).ifPresent(wallet -> {
            wallet.setAmount(wallet.getAmount() + amount);
            walletRepository.save(wallet);
        });
    }
}
