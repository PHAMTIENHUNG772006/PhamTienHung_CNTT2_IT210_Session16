package com.re.session16.model;

import com.re.session16.repository.TransactionHistory;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "wallet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Wallet {

    @Column(name = "wallet_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

    @OneToMany(mappedBy = "wallet",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<TransactionHistory> transactionHistory;
}
