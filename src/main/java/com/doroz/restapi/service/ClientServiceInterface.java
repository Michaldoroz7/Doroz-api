package com.doroz.restapi.service;

import com.doroz.restapi.model.Client;

public interface ClientServiceInterface {

    Iterable<Client> getClients();

    Client getClientById(Long id);

    Client addClient(Client client);

    void updateClient(Long id, Client client);

    void deleteClient(Long id);
}
