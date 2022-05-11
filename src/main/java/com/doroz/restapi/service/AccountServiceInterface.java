package com.doroz.restapi.service;

import com.doroz.restapi.model.Account;

import java.util.List;

public interface AccountServiceInterface {

    List<Account> getAccounts();
    Account getAccountById(Long id);
    Account addAccount(Account account);
    void updateAccount(Long id, Account account);
    void deleteAccount(Long id);
}
