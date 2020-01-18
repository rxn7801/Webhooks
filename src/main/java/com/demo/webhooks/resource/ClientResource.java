package com.demo.webhooks.resource;

import com.demo.webhooks.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/")
public class ClientResource {

    @Autowired
    private DeliveryService deliveryService;

    private AtomicInteger counter = new AtomicInteger();

    @GetMapping("push/{id}")
    public ResponseEntity<String> pushEvent(@PathVariable("id") Long subscriptionId) {
        return new ResponseEntity<>(deliveryService.pushMessage(subscriptionId, counter), HttpStatus.OK);
    }


}
