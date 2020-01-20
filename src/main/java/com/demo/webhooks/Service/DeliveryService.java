package com.demo.webhooks.Service;

import com.demo.webhooks.model.Delivery;
import com.demo.webhooks.model.Event;
import com.demo.webhooks.model.Subscription;
import com.demo.webhooks.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryService.class);

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


    public Delivery pushMessage(Event event) {

        final Subscription subscription = subscriptionService.getSubscription(event.getSubName(), event.getLevel());

        HttpEntity<Event> request = new HttpEntity<>(event);

        Delivery delivery = new Delivery();
        try {

            final ResponseEntity<Void> response = restTemplate.exchange(subscription.getUrl(), HttpMethod.POST, request, Void.class);
            LOGGER.info("Pushing notification to Client " + subscription.getUrl() + " with message " + event.getMessage());
            if (response.getStatusCodeValue() == 204) {
                LOGGER.info(" Acknowledgement received from Client! ");
                delivery.setStatus("Delivered");
            } else
                delivery.setStatus("Failed");

        } catch (Exception e) {
            delivery.setStatus("Failed");
        }
        deliveryRepository.save(delivery);


        return delivery;

    }
}
