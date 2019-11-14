package com.sample.app.DemoSpringBootApp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FULL_NAME", length = 64, nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String fullName;

    @NotBlank(message = "EMAIL is mandatory")
    @Column(name = "EMAIL")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Subscription> subscriptionList;

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public Customer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
