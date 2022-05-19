package com.doroz.restapi.repository;

import com.doroz.restapi.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
