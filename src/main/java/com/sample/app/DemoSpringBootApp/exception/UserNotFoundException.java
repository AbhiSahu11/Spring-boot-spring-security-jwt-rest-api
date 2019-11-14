package com.sample.app.DemoSpringBootApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8881858489333337457L;

    public UserNotFoundException(String exception) {
        super(exception);
    }

}
