package ch.alika.example.rest.exception;

import lombok.Data;
import lombok.Value;

import java.util.Date;

@Value
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
