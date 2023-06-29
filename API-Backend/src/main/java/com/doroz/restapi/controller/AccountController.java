package com.doroz.restapi.controller;

import com.doroz.restapi.dto.AccountDto;
import com.doroz.restapi.entity.Account;
import com.doroz.restapi.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountDto> showAccounts() {
        return accountService.getAccounts().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable("id") long id) {
        return mapToDto(accountService.getAccountById(id));
    }

    @PostMapping("/accounts")
    public Account newAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @DeleteMapping("/accounts/delete/{id}")
    public void deleteAccount(@PathVariable("id") long id) {
        accountService.deleteAccount(id);
        System.out.println("Deleted account: " + id);
    }


    private AccountDto mapToDto(Account account){
        AccountDto aDto = new AccountDto();
        aDto.setId(account.getId());
        aDto.setClient(account.getClientId());
        aDto.setSubscription(account.getSubscriptionId());
        return aDto;
    }
}
