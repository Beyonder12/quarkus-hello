package com.example.tvseries.rest;

import com.example.tvseries.dto.TVSeries;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;


@RegisterRestClient(baseUri = "https://api.tvmaze.com")
@Path("/shows")
public interface TVSeriesProxy {
    @GET
    List<TVSeries> getTVSeries();
    // https://api.tvmaze.com/shows/120
    @Path("/{id}")
    @GET
    TVSeries getTVSeriesById(@PathParam("id") int id);

}
