package com.demo.webhooks.repository;

import com.demo.webhooks.model.Delivery;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
