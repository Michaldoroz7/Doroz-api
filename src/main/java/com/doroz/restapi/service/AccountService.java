package com.doroz.restapi.service;

import com.doroz.restapi.entity.Account;
import com.doroz.restapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return (List<Account>) accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow();
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    public void updateAccount(Long id, Account account) {
        Account accountFromDb = accountRepository.findById(id).get();
        System.out.println("Updating Account: " + accountFromDb);
        accountFromDb.setSubscriptionId(account.getSubscriptionId());
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
        System.out.print("Account " + id + " deleted");
    }
}
