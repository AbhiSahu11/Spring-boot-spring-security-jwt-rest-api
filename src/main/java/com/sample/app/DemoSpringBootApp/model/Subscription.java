package com.sample.app.DemoSpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Subscription {

    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private int availableContent;
    private double price;

    @JsonIgnore
    private int remainingContent;

    @JsonIgnore
    private Date startDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableContent() {
        return availableContent;
    }

    public void setAvailableContent(int availableContent) {
        this.availableContent = availableContent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRemainingContent() {
        return remainingContent;
    }

    public void setRemainingContent(int remainingContent) {
        this.remainingContent = remainingContent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


}
