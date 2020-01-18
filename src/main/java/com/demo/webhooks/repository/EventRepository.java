package com.demo.webhooks.repository;


import com.demo.webhooks.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {
}
