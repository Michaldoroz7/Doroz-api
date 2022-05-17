package com.doroz.restapi.service;

import com.doroz.restapi.model.Account;

public interface AccountServiceInterface {

    Iterable<Account> getAccounts();

    Account getAccountById(Long id);

    Account addAccount(Account account);

    void updateAccount(Long id, Account account);

    void deleteAccount(Long id);
}
