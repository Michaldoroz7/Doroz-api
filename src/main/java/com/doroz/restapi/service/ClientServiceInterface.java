package com.doroz.restapi.service;

import com.doroz.restapi.model.Client;

import java.util.List;

public interface ClientServiceInterface {

    List<Client> getClients();
    Client getClientById(Long id);
    Client addClient(Client client);
    void updateClient(Long id, Client client);
    void deleteClient(Long id);
}
