package com.doroz.restapi.service;

import com.doroz.restapi.model.Client;
import com.doroz.restapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientService implements ClientServiceInterface {

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void updateClient(Long id, Client client) {
        Client clientFromDb = clientRepository.findById(id).get();
        System.out.println("Updating client: " + clientFromDb);
        clientFromDb.setEmail(client.getEmail());
        clientFromDb.setLogin(client.getLogin());
        clientFromDb.setPhoneNumber(client.getPhoneNumber());
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
        System.out.print("User " + id + " deleted");
    }
}
