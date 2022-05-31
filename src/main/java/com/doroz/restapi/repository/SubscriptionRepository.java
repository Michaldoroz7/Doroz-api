package com.doroz.restapi.repository;

import com.doroz.restapi.entity.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
