package com.sample.app.DemoSpringBootApp.model;

public class JwtResponse {

    private String jwtToken;
    private String status;
    private String message;

    public JwtResponse(String jwtToken, String status, String message) {
        this.jwtToken = jwtToken;
        this.status = status;
        this.message = message;
    }

    public JwtResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getToken() {
        return this.jwtToken;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
