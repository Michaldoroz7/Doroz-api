package com.doroz.restapi.repository;

import com.doroz.restapi.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
