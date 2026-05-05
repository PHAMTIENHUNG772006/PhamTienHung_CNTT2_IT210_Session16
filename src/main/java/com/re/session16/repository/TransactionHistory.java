package com.re.session16.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.awt.print.Pageable;

public interface TransactionHistory extends JpaRepository<TransactionHistory,Long> {
    Page<TransactionHistory> findByWalletId(Pageable pageable, Long id);

    @Query("select t from  TransactionHistory t where t.amount > :minAmount")
    Page<TransactionHistory> findLargeTransactions(Pageable pageable, Double minAmount);
}
