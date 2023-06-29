package com.doroz.restapi.dto;


import com.doroz.restapi.entity.Account;
import com.doroz.restapi.entity.Client;
import com.doroz.restapi.entity.Subscription;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto extends Account {
    private Long id;
    private Client client;
    private Subscription subscription;

}
