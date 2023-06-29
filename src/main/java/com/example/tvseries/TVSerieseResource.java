package com.example.tvseries;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/tvseries")
public class TVSerieseResource {

    @RestClient
    TVSeriesProxy proxy;

    @GET
    @Path("/{id}")
    public TVSeries getTVSeriesById(@PathParam("id") int id) {
        return proxy.getTVSeriesById(id);
    }
}
