package com.example.hello.exception.handler;

import com.example.hello.exception.ValidationException;
import io.vertx.core.json.JsonObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        JsonObject result = new JsonObject();
        result.put("message", exception.getMessage());
        result.put("code", "400");
        return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
    }
}
