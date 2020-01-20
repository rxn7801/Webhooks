//package com.demo.webhooks.resource;
//
//
//import com.demo.webhooks.model.Event;
//import com.demo.webhooks.repository.EventRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/")
//@CrossOrigin
//public class EventResource {
//
//    @Autowired
//    private EventRepository eventRepository;
//
//    @PostMapping("credits")
//    public ResponseEntity<Void> acceptCreditEvent(@RequestBody Event event) {
//        eventRepository.save(event);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PostMapping("debits")
//    public ResponseEntity<Void> acceptDebitEvent(@RequestBody Event event) {
//        eventRepository.save(event);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("events/{level}")
//    public ResponseEntity<List<Event>> getEvents(@PathVariable("level") String level) {
//        return new ResponseEntity<>(eventRepository.findAllByLevel(level), HttpStatus.OK);
//    }
//}
