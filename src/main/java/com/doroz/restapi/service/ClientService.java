package com.doroz.restapi.service;

import com.doroz.restapi.entity.Client;
import com.doroz.restapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void updateClient(Long id, Client client) {
        Client clientFromDb = clientRepository.findById(id).get();
        System.out.println("Updating client: " + clientFromDb);
        clientFromDb.setEmail(client.getEmail());
        clientFromDb.setLogin(client.getLogin());
        clientFromDb.setPhoneNumber(client.getPhoneNumber());
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
        System.out.print("User " + id + " deleted");
    }
}
