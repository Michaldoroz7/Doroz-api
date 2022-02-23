package com.doroz.restapi.repository;

import com.doroz.restapi.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository <Resource, Long> {
}
