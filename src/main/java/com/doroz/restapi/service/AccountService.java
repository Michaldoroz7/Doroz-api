package com.doroz.restapi.service;

import com.doroz.restapi.model.Account;
import com.doroz.restapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceInterface{

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void updateAccount(Long id, Account account) {
        Account accountFromDb = accountRepository.findById(id).get();
        System.out.println("Updating Account: " + accountFromDb);
        accountFromDb.setClient(account.getClient());
        accountFromDb.setSubscriptionId(account.getSubscriptionId());
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
        System.out.print("Account " + id + " deleted");
    }
}
