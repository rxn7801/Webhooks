package com.demo.webhooks.Service;

import com.demo.webhooks.model.Subscription;
import com.demo.webhooks.model.SubscriptionRequest;
import com.demo.webhooks.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.time.LocalDateTime.now;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(SubscriptionRequest subscriptionRequest) {

        Subscription subscription = new Subscription();
        subscription.setName(subscriptionRequest.getName());
        subscription.setCreatedAt(now());
        subscription.setLevel(subscriptionRequest.getLevel());
        subscription.setUrl(subscriptionRequest.getUrl());

        return subscriptionRepository.save(subscription);

    }

    public Optional<Subscription> getSubscription(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId);

    }
}
