package com.example.tvseries.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class BadRequestDto {

    @Schema(example = "400")
    public String code;
    @Schema(example = "BAD_REQUEST")
    public String message;

    public BadRequestDto(String code, String message){
        this.code = code;
        this.message = message;
    }
}
