package com.bookaero.exception;

import com.bookaero.dto.ErrorResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
    @Override
    public Response toResponse(IllegalArgumentException ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse("BAD_REQUEST", ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

