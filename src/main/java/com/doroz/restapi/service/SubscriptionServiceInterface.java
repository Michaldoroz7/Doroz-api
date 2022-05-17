package com.doroz.restapi.service;

import com.doroz.restapi.model.Subscription;

public interface SubscriptionServiceInterface {

    Iterable<Subscription> getSubscriptions();

    Subscription getSubscriptionById(Long id);

    Subscription addSubscription(Subscription subscription);

    void updateSubscription(Long id, Subscription subscription);

    void deleteSubscription(Long id);
}
