package ch.alika.example.restclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class ValueDTO {
    private Long id;
    private String quote;
}
