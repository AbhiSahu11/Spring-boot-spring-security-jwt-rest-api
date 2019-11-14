package com.sample.app.DemoSpringBootApp.service;

import com.sample.app.DemoSpringBootApp.dao.CustomerRepository;
import com.sample.app.DemoSpringBootApp.model.Customer;
import com.sample.app.DemoSpringBootApp.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = null;
        if (username.contains("@"))
            customer = customerRepository.findByEmail(username);
        else
            customer = customerRepository.findByFullName(username);

        if (customer == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(customer.getFullName(), customer.getPassword(),
                new ArrayList<>());
    }

    public Customer save(UserDTO user) {
        Customer customer = new Customer();
        customer.setFullName(user.getFullName());
        customer.setEmail(user.getEmail());
        customer.setPassword(bcryptEncoder.encode(user.getPassword()));
        return customerRepository.save(customer);
    }

}