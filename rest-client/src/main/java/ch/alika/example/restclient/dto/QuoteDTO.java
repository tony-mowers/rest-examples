package ch.alika.example.restclient.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class QuoteDTO {
    private String type;
    private ValueDTO value;
}
