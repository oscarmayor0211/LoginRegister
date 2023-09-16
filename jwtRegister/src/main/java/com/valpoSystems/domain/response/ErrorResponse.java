package com.valpoSystems.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private Integer statusCode;
    private String message;

    public ErrorResponse() {

    }
}
