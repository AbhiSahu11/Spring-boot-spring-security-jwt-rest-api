package com.sample.app.DemoSpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {

    private String fullName;
    private String email;
    private String password;
    private String availableCategory;
    private String subscribedCategory;
    private String customer;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSubscribedCategory() {
        return subscribedCategory;
    }

    public void setSubscribedCategory(String subscribedCategory) {
        this.subscribedCategory = subscribedCategory;
    }

    public String getAvailableCategory() {
        return availableCategory;
    }

    public void setAvailableCategory(String availableCategory) {
        this.availableCategory = availableCategory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
