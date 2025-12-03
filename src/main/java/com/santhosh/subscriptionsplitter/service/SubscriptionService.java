package com.santhosh.subscriptionsplitter.service;

import com.santhosh.subscriptionsplitter.model.Group;
import com.santhosh.subscriptionsplitter.model.Subscription;
import com.santhosh.subscriptionsplitter.repository.SubscriptionRepository;
import com.santhosh.subscriptionsplitter.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final GroupRepository groupRepository;
    public SubscriptionService(SubscriptionRepository subscriptionRepository, GroupRepository groupRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.groupRepository = groupRepository;
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
    public Double getSplitAmount(Long groupId) {

        // Step 1: Get the group
        Group group = groupRepository.findById(groupId).orElse(null);
        if (group == null) {
            return null; // or throw custom error
        }

        int totalPeople = group.getNumberOfPeople();

        // Step 2: Get subscriptions for this group
        List<Subscription> subs = getSubscriptionsByGroupId(groupId);

        // If no subscription exists
        if (subs.isEmpty()) {
            return null; // or return 0.0
        }

        // For now, assume one subscription per group
        Subscription sub = subs.get(0);

        // Step 3: Calculate split

        return sub.getAmount() / totalPeople;
    }

}
