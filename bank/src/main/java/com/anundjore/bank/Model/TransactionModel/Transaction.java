package com.anundjore.bank.Model.TransactionModel;

import java.time.Instant;

import org.hibernate.annotations.ManyToAny;

import com.anundjore.bank.Model.AccountModel.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

    // @Id for primary key id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autogenerate a unique ID
    private long id;

    private long registeredTime;
    private long executedTime;
    private Boolean success;
    private double cashAmount;

    @ManyToOne
    @JoinColumn(name = "source_account_id", referencedColumnName = "id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id", referencedColumnName = "id")
    private Account destinationAccount;

    public Transaction() {
        this.registeredTime = Instant.now().toEpochMilli();
    }

    public Transaction(Long id, Long registeredTime, Long executedTime, Boolean success,
            Double cashAmount, Account sourceAccount, Account destinationAccount) {
        this.id = id;
        this.registeredTime = registeredTime;
        this.executedTime = executedTime;
        this.success = success;
        this.cashAmount = cashAmount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisteredTime() {
        return this.registeredTime;
    }

    public void setRegisteredTime(Long registeredTime) {
        this.registeredTime = registeredTime;
    }

    public Long getExecutedTime() {
        return this.executedTime;
    }

    public void setExecutedTime(Long executedTime) {
        this.executedTime = executedTime;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public double getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Account getSourceAccount() {
        return this.sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Account getDestinationAccount() {
        return this.destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

}
