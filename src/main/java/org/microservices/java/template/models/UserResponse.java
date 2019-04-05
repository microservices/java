package org.microservices.java.template.models;

import java.io.Serializable;

public class UserResponse implements Serializable {
    private String message;

    // required for the serializer
    public UserResponse() {}

    public UserResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}