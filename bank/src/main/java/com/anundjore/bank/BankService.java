package com.anundjore.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anundjore.bank.*;
import com.anundjore.bank.Model.AccountModel.Account;
import com.anundjore.bank.Repository.BankAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class BankService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public void transfer(String sourceAccountNumber, String destinationAccountNumber, Double amount) {
        Account source = bankAccountRepository.findByAccNumber(sourceAccountNumber);
        Account destination = bankAccountRepository.findByAccNumber(destinationAccountNumber);

        if (source == null || destination == null) {
            throw new IllegalArgumentException("Account not found");
        }

        // negative balance should return response 400
        if (source.getAvailableCash() < amount) {
            throw new IllegalArgumentException("Not enough money in source account");
        }

        source.setBalance(source.getAvailableCash() - amount);
        destination.setBalance(destination.getAvailableCash() + amount);

        bankAccountRepository.save(source);
        bankAccountRepository.save(destination);
    }

}
