package com.re.session16.service;

public interface WalletService {
    boolean transfer(Long fromWalletId, Long toWalletId, double amount);
    void saveSystemLog(String message);

}
