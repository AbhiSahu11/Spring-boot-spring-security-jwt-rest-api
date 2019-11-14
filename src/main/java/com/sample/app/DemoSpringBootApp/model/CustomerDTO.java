package com.sample.app.DemoSpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDTO {

    private List<Category> availableCategories;
    private List<Category> subscribedCategories;

    public List<Category> getAvailableCategories() {
        return availableCategories;
    }

    public void setAvailableCategories(List<Category> availableCategories) {
        this.availableCategories = availableCategories;
    }

    public List<Category> getSubscribedCategories() {
        return subscribedCategories;
    }

    public void setSubscribedCategories(List<Category> subscribedCategories) {
        this.subscribedCategories = subscribedCategories;
    }
}
