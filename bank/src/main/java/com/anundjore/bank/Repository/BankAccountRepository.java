package com.anundjore.bank.Repository;

import com.anundjore.bank.Model.AccountModel.*;
import org.springframework.data.jpa.repository.JpaRepository;;

public interface BankAccountRepository extends JpaRepository<Account, Long> {
    Account findByAccNumber(String accountNumber);

}
