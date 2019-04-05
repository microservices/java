package org.microservices.java.template.models;

import java.io.Serializable;

public class User implements Serializable {
    private String name;

    // required for the serializer
    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}