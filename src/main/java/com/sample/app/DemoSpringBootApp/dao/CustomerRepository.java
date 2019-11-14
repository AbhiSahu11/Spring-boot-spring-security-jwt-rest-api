package com.sample.app.DemoSpringBootApp.dao;


import com.sample.app.DemoSpringBootApp.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long> {
        Customer findByFullName(String name);
        Customer findByEmail(String email);
}
