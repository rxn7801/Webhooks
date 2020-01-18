package com.demo.webhooks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Event {

    @Id
    private UUID id;
    private String message;

}
