package com.bookaero.exception;

import com.bookaero.dto.ErrorResponse;
import com.mongodb.MongoException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MongoExceptionMapper implements ExceptionMapper<MongoException> {
    @Override
    public Response toResponse(com.mongodb.MongoException ex) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("DATABASE_ERROR", "MongoDB error: " + ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

