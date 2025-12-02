package com.santhosh.subscriptionsplitter.controllers;

import com.santhosh.subscriptionsplitter.model.Subscription;
import com.santhosh.subscriptionsplitter.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @GetMapping("/group/{groupId}")
    public List<Subscription> getSubscriptionsByGroup(@PathVariable Long groupId) {
        return subscriptionService.getSubscriptionsByGroupId(groupId);
    }
}
