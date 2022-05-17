package com.doroz.restapi.service;

import com.doroz.restapi.model.Account;
import com.doroz.restapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceInterface {

    @Autowired
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void updateAccount(Long id, Account account) {
        Account accountFromDb = accountRepository.findById(id).get();
        System.out.println("Updating Account: " + accountFromDb);
        accountFromDb.setSubscriptionId(account.getSubscriptionId());
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
        System.out.print("Account " + id + " deleted");
    }
}
