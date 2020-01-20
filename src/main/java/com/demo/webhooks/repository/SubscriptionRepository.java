package com.demo.webhooks.repository;

import com.demo.webhooks.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

    Subscription findByNameAndLevel(String name, String level);
}
