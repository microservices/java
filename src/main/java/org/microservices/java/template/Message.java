package org.microservices.java.template;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.microservices.java.template.models.User;
import org.microservices.java.template.models.UserResponse;


@Path("message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Message {

    @POST
    public UserResponse create(User user) {
        String msg = String.format("Hello %s", user.getName());
        return new UserResponse(msg);
    }
}
