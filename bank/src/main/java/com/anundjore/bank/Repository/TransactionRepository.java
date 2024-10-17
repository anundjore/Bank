package com.anundjore.bank.Repository;

import com.anundjore.bank.Model.TransactionModel.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}