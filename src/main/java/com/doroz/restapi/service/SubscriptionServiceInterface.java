package com.doroz.restapi.service;

import com.doroz.restapi.model.Subscription;

import java.util.List;

public interface SubscriptionServiceInterface {

    List<Subscription> getSubscriptions();
    Subscription getSubscriptionById(Long id);
    Subscription addSubscription(Subscription subscription);
    void updateSubscription(Long id, Subscription subscription);
    void deleteSubscription(Long id);
}
