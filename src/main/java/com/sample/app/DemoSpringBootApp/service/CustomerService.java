package com.sample.app.DemoSpringBootApp.service;

import com.sample.app.DemoSpringBootApp.dao.CategoryRepository;
import com.sample.app.DemoSpringBootApp.dao.CustomerRepository;
import com.sample.app.DemoSpringBootApp.dao.SubscriptionRepository;
import com.sample.app.DemoSpringBootApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public ResponseEntity<?> saveOrUpdateCustomer(UserDTO userDTO) {

        // Mail , Avaliable category
        Optional<Category> category = Optional.of(categoryRepository.findByName(userDTO.getAvailableCategory()));

        Subscription subscription = new Subscription();

        subscription.setAvailableContent(category.get().getAvailableContent());
        subscription.setName(category.get().getName());
        subscription.setPrice(category.get().getPrice());
        subscription.setStartDate(new Date());

        Optional<Customer> customer = Optional.of(customerRepository.findByEmail(userDTO.getEmail()));
        subscription.setCustomer(customer.get());

        subscriptionRepository.save(subscription);

        return ResponseEntity.ok(new JwtResponse("Success", "Category is subscribed successfully"));
    }

    public ResponseEntity<?> shareSubscriptionCustomer(UserDTO userDTO) {

        // Customer , email , Subscribed category
        Optional<Category> category = Optional.of(categoryRepository.findByName(userDTO.getSubscribedCategory()));
        Subscription subscription = new Subscription();

        subscription.setAvailableContent(category.get().getAvailableContent());
        subscription.setName(category.get().getName());
        subscription.setPrice(category.get().getPrice());
        subscription.setStartDate(new Date());

        Optional<Customer> customer = Optional.of(customerRepository.findByFullName(userDTO.getCustomer()));
        subscription.setCustomer(customer.get());

        subscriptionRepository.save(subscription);

        return ResponseEntity.ok(new JwtResponse("Success", "Category is Shared successfully"));
    }

    public CustomerDTO getCustomerByName(String name) {

        return Optional.of(customerRepository.findByFullName(name)).map(this::setCategories)
                .orElseThrow(() -> new RuntimeException("USer Not found"));
    }

    public CustomerDTO setCategories(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();

        List<Category> availableCategoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(availableCategoryList::add); // Available Category List

        List<Category> subscribedCategoryList = customer.getSubscriptionList().stream().map(this::categoryDto)
                .collect(Collectors.toList());
        // Need to check
        if (customer.getSubscriptionList() != null) {

            for (Subscription subscription : customer.getSubscriptionList()) {

                Predicate<Category> condition = category -> category.getName().equals(subscription.getName());
                availableCategoryList.removeIf(condition);
            }
            customerDTO.setSubscribedCategories(subscribedCategoryList);
            customerDTO.setAvailableCategories(availableCategoryList);
        } else {
            customerDTO.setAvailableCategories(availableCategoryList);
        }

        return customerDTO;
    }

    private Category categoryDto(Subscription subscription) {

        Category subscribedCategory = new Category();

        subscribedCategory.setName(subscription.getName());
        subscribedCategory.setRemainingContent(subscription.getRemainingContent());
        subscribedCategory.setPrice(subscription.getPrice());

        // Predicate<Category> condition = category ->
        // category.getName().equals(subscription.getName());

        return subscribedCategory;

    }

}
