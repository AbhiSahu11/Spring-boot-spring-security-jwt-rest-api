package com.sample.app.DemoSpringBootApp.dao;

import com.sample.app.DemoSpringBootApp.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, String> {
}
