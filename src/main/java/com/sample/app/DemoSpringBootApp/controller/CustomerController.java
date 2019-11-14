package com.sample.app.DemoSpringBootApp.controller;

import com.sample.app.DemoSpringBootApp.model.CustomerDTO;
import com.sample.app.DemoSpringBootApp.model.UserDTO;
import com.sample.app.DemoSpringBootApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path = "/customer/{id}" , method = RequestMethod.GET)
    public CustomerDTO getCustomerByName(@PathVariable("id") String name){
        return customerService.getCustomerByName(name);
    }

    @RequestMapping(path = "/customer" , method = RequestMethod.POST)
    public ResponseEntity<?> updateCustomerWithCategory(@RequestBody UserDTO customer){
         return customerService.saveOrUpdateCustomer(customer);
    }

    @RequestMapping(path = "/share" , method = RequestMethod.POST)
    public ResponseEntity<?> shareSubscriptionCategory(@RequestBody UserDTO customer){
        return customerService.shareSubscriptionCustomer(customer);
    }
}
