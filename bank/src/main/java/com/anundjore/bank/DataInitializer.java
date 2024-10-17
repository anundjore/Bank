package com.anundjore.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anundjore.bank.Model.AccountModel.Account;
import com.anundjore.bank.Repository.BankAccountRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        // Hardcoding some accounts
        Account account1 = new Account(1L, "Aanund", 1000.0);
        Account account2 = new Account(2L, "Helena", 500.0);
        Account account3 = new Account(3L, "Kverneriet", 750.0);

        bankAccountRepository.save(account1);
        bankAccountRepository.save(account2);
        bankAccountRepository.save(account3);

        System.out.println("Initialized bank accounts:");
        bankAccountRepository.findAll().forEach(account -> {
            System.out.println("Account ID: " + account.getId() + ", Name: " + account.getName() + ", Balance: "
                    + account.getAvailableCash());
        });
    }
}
