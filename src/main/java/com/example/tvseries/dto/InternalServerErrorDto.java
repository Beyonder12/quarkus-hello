package com.example.tvseries.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class InternalServerErrorDto {
    @Schema(example = "Internal Server Error")
    public String message;

    public InternalServerErrorDto(String message) {
    }
}
