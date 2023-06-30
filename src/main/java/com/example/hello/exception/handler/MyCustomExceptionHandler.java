package com.example.hello.exception.handler;

import com.example.hello.exception.MyCustomException;
import com.example.hello.exception.ValidationException;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyCustomExceptionHandler implements ExceptionMapper<MyCustomException> {

    private static final Logger log = LoggerFactory.getLogger(MyCustomExceptionHandler.class);
    @Override
    public Response toResponse(MyCustomException exception) {
        log.error("Something went wrong : {} ", exception);
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .build();
    }
}
