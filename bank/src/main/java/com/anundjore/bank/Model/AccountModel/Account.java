package com.anundjore.bank.Model.AccountModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    private Long id;
    private String name;
    private double availableCash;

    public Account() {

    }

    public Account(Long id, String name, Double availableCash) {
        this.id = id;
        this.name = name;
        this.availableCash = availableCash;
    }

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public double getAvailableCash() {
        return this.availableCash;
    }

    public void setBalance(double balance) {
        this.availableCash = balance;

    }

}
