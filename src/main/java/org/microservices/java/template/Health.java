package org.microservices.java.template;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.microservices.java.template.models.User;
import org.microservices.java.template.models.UserResponse;


@Path("health")
public class Health {

    @GET
    public String check() {
        return "OK";
    }
}
