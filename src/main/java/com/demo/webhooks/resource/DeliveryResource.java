package com.demo.webhooks.resource;


import com.demo.webhooks.model.Event;
import com.demo.webhooks.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class DeliveryResource {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("events")
    public ResponseEntity<Void> getEvents(@RequestBody Event event) {
        eventRepository.save(event);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("events")
    public ResponseEntity<List<Event>> getEvents() {
        return new ResponseEntity<>((List<Event>) eventRepository.findAll(), HttpStatus.OK);
    }
}
