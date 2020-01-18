package com.demo.webhooks.resource;


import com.demo.webhooks.Service.SubscriptionService;
import com.demo.webhooks.model.Event;
import com.demo.webhooks.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DeliveryResource {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private EventRepository eventRepository;


    @PostMapping("events")
    public ResponseEntity<Void> getEvents(@RequestBody Event event) {
        eventRepository.save(event);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
