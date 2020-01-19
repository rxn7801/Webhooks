package com.demo.webhooks.resource;

import com.demo.webhooks.Service.DeliveryService;
import com.demo.webhooks.model.Delivery;
import com.demo.webhooks.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class ClientResource {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("push/{id}")
    public ResponseEntity<Delivery> pushEvent(@RequestBody Event event, @PathVariable("id") Long subscriptionId) {
        return new ResponseEntity<>(deliveryService.pushMessage(event, subscriptionId), HttpStatus.OK);
    }


}
