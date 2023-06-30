package com.example.hello.exception.handler;

import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ThrowableExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger log = LoggerFactory.getLogger(ThrowableExceptionHandler.class);

    @Override
    public Response toResponse(Throwable ex) {
        log.error("hello-Service", ex);
        JsonObject result = new JsonObject();
        result.put("message",ex.getMessage());
        return Response.serverError().entity(result).build();
    }
}
