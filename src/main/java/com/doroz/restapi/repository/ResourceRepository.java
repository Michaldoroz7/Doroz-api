package com.doroz.restapi.repository;

import com.doroz.restapi.Resource;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResourceRepository extends CrudRepository <Resource, Long> {

}
