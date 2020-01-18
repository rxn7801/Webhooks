package com.demo.webhooks.Service;

import com.demo.webhooks.model.Delivery;
import com.demo.webhooks.model.Event;
import com.demo.webhooks.model.Subscription;
import com.demo.webhooks.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DeliveryService {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Bean
    private RestTemplate template() {
        return new RestTemplate();
    }


    public String pushMessage(Long subscriptionId, AtomicInteger counter) {

        final Optional<Subscription> subscriptionDetails = subscriptionService.getSubscription(subscriptionId);

        Event newEvent = new Event();
        newEvent.setId(UUID.randomUUID());
        newEvent.setMessage("This is test event # " + counter.incrementAndGet());

        HttpEntity<Event> request = new HttpEntity<>(newEvent);

        Delivery delivery = new Delivery();

        subscriptionDetails.ifPresent(subscription -> {
            final ResponseEntity<Void> response = restTemplate.exchange(subscription.getUrl(), HttpMethod.POST, request, Void.class);

            delivery.setEventId(newEvent.getId());
            if (response.getStatusCodeValue() == 204)
                delivery.setStatus("Delivered");
            else
                delivery.setStatus("Failed");
            deliveryRepository.save(delivery);

        });

        return "Event posting Status " + delivery.getStatus() + "!";

    }
}
