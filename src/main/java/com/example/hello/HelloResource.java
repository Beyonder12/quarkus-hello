package com.example.hello;


import com.example.hello.exception.BusinessException;
import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hello")
@Tag(name = "Hello", description = "Simple behavior")
public class HelloResource {

    private static final Logger log = LoggerFactory.getLogger(HelloResource.class);

    @GET
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/greet-throw")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloThrow() throws BusinessException {
        log.info("helloThrow method called");
        throw new BusinessException("Conflict");
//        var num = 1/0;

//        return Response.ok().status(num).build();
//        throw new MyCustomException("Custom Exception");
//        throw new ValidationException("failed");
//        throw new WebApplicationException("BAD_REQUEST", Response.Status.BAD_REQUEST);
    }
    @GET
    @Blocking
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hello> getHello() {
        return Hello.listAll();
    }

    @GET
    @Blocking
    @Path("/create")
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public String createHello() {
        Hello hello = new Hello();
        hello.message = "Hello, World!";
        hello.persist();
        return "Hello Created";
    }
}
