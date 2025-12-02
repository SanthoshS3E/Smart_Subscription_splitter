package com.santhosh.subscriptionsplitter.service;

import com.santhosh.subscriptionsplitter.model.Subscription;
import com.santhosh.subscriptionsplitter.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptionsByGroupId(Long groupId) {
        return subscriptionRepository.findAll()
                .stream()
                .filter(s -> s.getGroupId().equals(groupId))
                .toList();
    }
}
