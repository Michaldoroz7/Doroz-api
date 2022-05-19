package com.doroz.restapi.controller;

import com.doroz.restapi.dto.ClientDto;
import com.doroz.restapi.entity.Client;
import com.doroz.restapi.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDto> showClients() {
        return clientService.getClients().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/clients/{id}")
    public ClientDto showSpecificClient(@PathVariable("id") long id) {
        return mapToDto(clientService.getClientById(id));
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/clients/delete/{id}")
    public void deleteClient(@PathVariable("id") long id) {
        clientService.deleteClient(id);
        System.out.println("Deleted client: " + id);
    }

    private ClientDto mapToDto(Client client) {
        ClientDto cDto = new ClientDto();
        cDto.setId(client.getId());
        cDto.setLogin(client.getLogin());
        cDto.setPassword(client.getPassword());
        cDto.setEmail(client.getEmail());
        cDto.setPhoneNumber(client.getPhoneNumber());

        return cDto;
    }
}
