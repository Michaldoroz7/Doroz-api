package com.doroz.restapi.controller;

import com.doroz.restapi.dto.ClientDto;
import com.doroz.restapi.entity.Client;
import com.doroz.restapi.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        client.setPassword(clientService.encryptPassword(client.getPassword()));
        if (!emailValidation(client)) {
            //Need to think about it and refactor for better response
            return (Client) ResponseEntity.badRequest();
        } else {
            return clientService.addClient(client);
        }
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

    private boolean emailValidation(Client client) {
        LoggingController loggingController = new LoggingController();

        final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(client.getEmail());
        String msg;
        boolean status;

        if (matcher.matches()) {

            msg = "Email is OK!";
            loggingController.logSomeInfo(msg, "info");
            status = true;
        } else {
            msg = "Email is NOT OK!, check it";
            loggingController.logSomeInfo(msg, "warn");
            status = false;
        }
        return status;
    }
}
