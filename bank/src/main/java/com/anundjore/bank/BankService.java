package com.anundjore.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anundjore.bank.Model.AccountModel.Account;
import com.anundjore.bank.Model.TransactionModel.Transaction;
import com.anundjore.bank.Repository.BankAccountRepository;
import com.anundjore.bank.Repository.TransactionRepository;
import java.time.Instant;

import jakarta.transaction.Transactional;

@Service
public class BankService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction transfer(String sourceAccountNumber, String destinationAccountNumber, Double amount) {
        Long sourceId;
        Long destinationId;
        try {
            sourceId = Long.parseLong(sourceAccountNumber);
            destinationId = Long.parseLong(destinationAccountNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid account number format");
        }

        Account source = bankAccountRepository.findById(sourceId).orElse(null);
        Account destination = bankAccountRepository.findById(destinationId).orElse(null);

        if (source == null || destination == null) {
            throw new IllegalArgumentException("Account not found");
        }

        if (source.getAvailableCash() < amount) {
            throw new IllegalArgumentException("Not enough money in source account");
        }

        source.setBalance(source.getAvailableCash() - amount);
        destination.setBalance(destination.getAvailableCash() + amount);

        bankAccountRepository.save(source);
        bankAccountRepository.save(destination);

        Transaction transaction = new Transaction();
        transaction.setSourceAccount(source);
        transaction.setDestinationAccount(destination);
        transaction.setCashAmount(amount);
        transaction.setExecutedTime(Instant.now().toEpochMilli());
        transaction.setSuccess(true);

        return transactionRepository.save(transaction);

    }
}
