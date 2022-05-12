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
}
