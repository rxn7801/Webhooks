package com.demo.webhooks.resource;

import com.demo.webhooks.Service.SubscriptionService;
import com.demo.webhooks.model.Subscription;
import com.demo.webhooks.model.SubscriptionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SubscriptionResource {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("webhooks")
    public ResponseEntity<Subscription> createWebHooks
            (@RequestBody SubscriptionRequest subscriptionRequest) {

        return new ResponseEntity<>(subscriptionService.createSubscription(subscriptionRequest),
                HttpStatus.CREATED);
    }

    @GetMapping("webhooks")
    public ResponseEntity<List<Subscription>> getWebHooks() {
        return new ResponseEntity<>(subscriptionService.getSubscriptions(), HttpStatus.OK);
    }

}
