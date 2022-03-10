package com.doroz.restapi.repository;

import com.doroz.restapi.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByLogin(String login);

    Client findById(long id);
}
