package com.doroz.restapi.service;

import com.doroz.restapi.model.Subscription;
import com.doroz.restapi.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SubscriptionService implements SubscriptionServiceInterface{

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Iterable<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).get();
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void updateSubscription(Long id, Subscription subscription) {
        Subscription subscriptionFromDb = subscriptionRepository.findById(id).get();
        System.out.println("Updating Subscription: " + subscriptionFromDb);
        subscriptionFromDb.setResource(subscription.getResource());
        subscriptionFromDb.setEndDate(subscription.getEndDate());
        subscriptionFromDb.setStartDate(subscription.getStartDate());
    }

    @Override
    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
        System.out.println("Subscription " + id + " deleted");
    }
}
