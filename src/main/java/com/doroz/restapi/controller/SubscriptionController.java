package com.doroz.restapi.controller;


import com.doroz.restapi.model.Subscription;
import com.doroz.restapi.service.SubscriptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscriptions")
    public Iterable<Subscription> showSubscriptions(){
        return subscriptionService.getSubscriptions();
    }

    @GetMapping("/subscriptions/{id}")
    public Subscription getSubscriptionById(@PathVariable("id") long id){
        return subscriptionService.getSubscriptionById(id);
    }
}
