package com.doroz.restapi.controller;


import com.doroz.restapi.dto.SubscriptionDto;
import com.doroz.restapi.entity.Subscription;
import com.doroz.restapi.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionDto> showSubscriptions() {
        return subscriptionService.getSubscriptions().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/subscriptions/{id}")
    public SubscriptionDto getSubscriptionById(@PathVariable("id") long id) {
        return mapToDto(subscriptionService.getSubscriptionById(id));
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

    private SubscriptionDto mapToDto(Subscription subscription) {
        SubscriptionDto sDto = new SubscriptionDto();
        sDto.setId(subscription.getId());
        sDto.setSubtype(subscription.getSubType());
        sDto.setStartDate(subscription.getStartDate());
        sDto.setEndDate(subscription.getEndDate());
        sDto.setResource(subscription.getResource());

        return sDto;
    }


}
