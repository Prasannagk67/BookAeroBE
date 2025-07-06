package com.bookaero.controller;

import com.bookaero.entity.User;
import com.bookaero.exception.DuplicateFieldException;
import com.bookaero.service.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Inject
    UserService userService;

    @POST
    public Response userRegister(User user) {
        LOGGER.infof("Received registration request for username: %s, email: %s", user.userName, user.email);

        try {
            User registeredUser = userService.userRegister(user);
            LOGGER.infof("User registered successfully: %s", registeredUser.userName);
            return Response.status(Response.Status.CREATED).entity(registeredUser).build();
        } catch (DuplicateFieldException e) {
            LOGGER.warnf("Duplicate field error for user: %s - %s", user.userName, e.getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(new ErrorResponse(e.getMessage()))
                    .build();
        } catch (IllegalArgumentException e) {
            LOGGER.errorf("Validation error during registration for user: %s - %s", user.userName, e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse(e.getMessage()))
                    .build();
        } catch (Exception e) {
            LOGGER.errorf("Unexpected error during registration: %s", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ErrorResponse("Internal Server Error"))
                    .build();
        }
    }

    public static class ErrorResponse {
        private String message;

        public ErrorResponse() {}

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() { return message; }

        public void setMessage(String message) { this.message = message; }
    }
}
