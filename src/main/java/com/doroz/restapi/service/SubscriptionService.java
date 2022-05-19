package com.doroz.restapi.service;

import com.doroz.restapi.entity.Subscription;
import com.doroz.restapi.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getSubscriptions() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id).get();
    }

    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public void updateSubscription(Long id, Subscription subscription) {
        Subscription subscriptionFromDb = subscriptionRepository.findById(id).get();
        System.out.println("Updating Subscription: " + subscriptionFromDb);
        subscriptionFromDb.setResource(subscription.getResource());
        subscriptionFromDb.setEndDate(subscription.getEndDate());
        subscriptionFromDb.setStartDate(subscription.getStartDate());
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
        System.out.println("Subscription " + id + " deleted");
    }
}
