package com.demo.webhooks.resource;

import com.demo.webhooks.Service.SubscriptionService;
import com.demo.webhooks.model.Subscription;
import com.demo.webhooks.model.SubscriptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class SubscriptionResource {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("webhooks")
    public ResponseEntity<Subscription> createWebHooks
            (@RequestBody SubscriptionRequest subscriptionRequest) {

        return new ResponseEntity<>(subscriptionService.createSubscription(subscriptionRequest),
                HttpStatus.CREATED);
    }

}
