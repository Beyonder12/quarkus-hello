package com.example.tvseries.resource;

import com.example.tvseries.dto.TVSeries;
import com.example.tvseries.rest.TVSeriesProxy;
import com.example.tvseries.dto.BadRequestDto;
import com.example.tvseries.dto.InternalServerErrorDto;
import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
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
    @Blocking
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all TV series", description = "Get all TV series")
    @APIResponses(value = {
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BadRequestDto.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = InternalServerErrorDto.class)))
    })
    public List<TVSeries> getTVSeries() {
        log.info("getTVSeries method called");
        return proxy.getTVSeries();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get TV series by Id", description = "Get TV series by Id")
    @APIResponses(value = {
            @APIResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BadRequestDto.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = InternalServerErrorDto.class)))
    })
    public TVSeries getTVSeriesById(@PathParam("id") int id) {
        log.info("getTVSeriesById method called with id: {}", id);
        return proxy.getTVSeriesById(id);
    }
}
