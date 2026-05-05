package com.re.session16.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.awt.print.Pageable;

public interface TransactionRepository extends JpaRepository<TransactionRepository,Long> {
    Page<TransactionRepository> findByWalletId(Pageable pageable, Long id);

    @Query("select t from  TransactionHistory t where t.amount > :minAmount")
    Page<TransactionRepository> findLargeTransactions(Pageable pageable, Double minAmount);
}
