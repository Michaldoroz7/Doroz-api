package com.doroz.restapi.controller;

import com.doroz.restapi.model.Client;
import com.doroz.restapi.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public Iterable<Client> showClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/{id}")
    public Client showSpecificClient(@PathVariable("id") long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @DeleteMapping("/clients/delete/{id}")
    public void deleteClient(@PathVariable("id") long id){
        clientService.deleteClient(id);
        System.out.println("Deleted client: " + id);
    }
}
