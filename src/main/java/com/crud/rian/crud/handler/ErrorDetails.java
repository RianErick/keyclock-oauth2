package com.crud.rian.crud.handler;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.Instant;

@Getter
public class ErrorDetails {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss" , locale = "America/Sao_Paulo")
    private Instant timestamp;

    private String error;

    private String message;
}
