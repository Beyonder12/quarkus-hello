package com.example.tvseries.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.net.URL;

public class TVSeries {
    @Schema(title = "id", example = "1", description = "Unique identifier of the user.")
    int id;

    @Schema(title = "name", example = "John Doe", description = "Name of the user.")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
