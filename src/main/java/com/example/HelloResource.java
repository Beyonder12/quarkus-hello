package com.example;

import io.smallrye.common.annotation.Blocking;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class HelloResource {

    @GET()
    @Path("/greet")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
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
