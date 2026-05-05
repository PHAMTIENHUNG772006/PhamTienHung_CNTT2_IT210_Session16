package com.re.session16.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactionHistory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
