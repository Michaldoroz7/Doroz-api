package com.doroz.restapi.controller;

import com.doroz.restapi.model.Account;
import com.doroz.restapi.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public Iterable<Account> showAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable("id") long id) {
        return accountService.getAccountById(id);
    }
}
