package com.example.tvseries;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tvseries")
public class TVSerieseResource {

    private final static Logger log = LoggerFactory.getLogger(TVSerieseResource.class);
    @RestClient
    TVSeriesProxy proxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TVSeries> getTVSeries() {
        log.info("Method : getTVSeries...");
        return proxy.getTVSeries();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TVSeries getTVSeriesById(@PathParam("id") int id) {
        log.info("Method : getTVSeriesById...{}", id);
        var resp = proxy.getTVSeriesById(id);
        System.out.println(resp);
//        return null;
        return resp;
    }
}
