package com.bookaero.exception;

import com.bookaero.dto.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.MediaType;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        exception.printStackTrace();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse(
                        "INTERNAL_SERVER_ERROR",
                        exception.getMessage() != null ? exception.getMessage() : "Unexpected server error"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

