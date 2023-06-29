package com.doroz.restapi.dto;


import com.doroz.restapi.entity.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto extends Client {
    private Long id;
    private String login;
    private String password;
    private String email;
    private int phoneNumber;
}
