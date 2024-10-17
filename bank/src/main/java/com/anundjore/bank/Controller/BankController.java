package com.anundjore.bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anundjore.bank.BankService;
import com.anundjore.bank.Model.TransactionModel.Transaction;

@RestController
@RequestMapping("api/")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(
            @RequestParam String sourceAccount,
            @RequestParam String destinationAccount,
            @RequestParam Double amount) {
        try {
            Transaction transaction = bankService.transfer(sourceAccount, destinationAccount, amount);
            return ResponseEntity.ok(transaction);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
