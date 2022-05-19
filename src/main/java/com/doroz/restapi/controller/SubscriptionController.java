package com.doroz.restapi.controller;


import com.doroz.restapi.entity.Subscription;
import com.doroz.restapi.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscriptions")
    public List<Subscription> showSubscriptions() {
        return (List<Subscription>) subscriptionService.getSubscriptions();
    }

    @GetMapping("/subscriptions/{id}")
    public Subscription getSubscriptionById(@PathVariable("id") long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping("/subscriptions")
    public Subscription newSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @DeleteMapping("/subscriptions/delete/{id}")
    public void deleteSubscription(@PathVariable("id") long id) {
        subscriptionService.deleteSubscription(id);
        System.out.println("Deleted subscription: " + id);
    }

}
