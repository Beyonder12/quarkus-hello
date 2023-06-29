package com.example.tvseries;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RegisterRestClient(baseUri = "https://api.tvmaze.com")
@Path("/shows")
public interface TVSeriesProxy {
    // https://api.tvmaze.com/shows/120
    @Path("/{id}")
    TVSeries getTVSeriesById(@PathParam("id") int id);
}
