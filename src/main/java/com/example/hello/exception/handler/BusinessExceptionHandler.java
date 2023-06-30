package com.example.hello.exception.handler;

import com.example.hello.exception.BusinessException;
import com.example.hello.exception.ValidationException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

    private static final Logger log = LoggerFactory.getLogger(BusinessExceptionHandler.class);
    @Override
    public Response toResponse(BusinessException exception) {
        log.error("Something went wrong : {} ", exception);
        JsonObject entity = new JsonObject();
        entity.put("message", exception.getMessage());
        return Response.status(Response.Status.CONFLICT)
                .entity(entity)
                .build();
    }
}
