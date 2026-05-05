package com.re.session16.service;

import com.re.session16.model.TransactionHistory;
import com.re.session16.model.Wallet;
import com.re.session16.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public boolean transfer(Long fromWalletId, Long toWalletId, double amount) {
        List<Wallet> wallets = walletRepository.findAll();

        Optional<Wallet> fromWallet = walletRepository.findById(fromWalletId);
        Optional<Wallet> toWallet =  walletRepository.findById(toWalletId);


        if(fromWallet.isPresent() && toWallet.isPresent()) {
            fromWallet.get().setBalance(fromWallet.get().getBalance() - amount);
            toWallet.get().setBalance(toWallet.get().getBalance() + amount);
            walletRepository.saveAll(wallets);
            return true;
        }else {
            throw new RuntimeException("không tìm thấy wallet");
        }
    }

    @Override
    public void saveSystemLog(String message) {

    }
}
