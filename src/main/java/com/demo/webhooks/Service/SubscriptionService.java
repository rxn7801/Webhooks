package com.demo.webhooks.Service;

import com.demo.webhooks.model.Subscription;
import com.demo.webhooks.model.SubscriptionRequest;
import com.demo.webhooks.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    Subscription getSubscription(String name, String level) {
        return subscriptionRepository.findByNameAndLevel(name, level);

    }

    public List<Subscription> getSubscriptions() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }


    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }
}
