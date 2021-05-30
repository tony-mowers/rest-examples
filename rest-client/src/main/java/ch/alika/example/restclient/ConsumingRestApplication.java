package ch.alika.example.restclient;

import ch.alika.example.restclient.dto.QuoteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * This code is based upon Spring guide:
 * https://spring.io/guides/gs/consuming-rest/
 *
 *
 */
@Slf4j
@SpringBootApplication
public class ConsumingRestApplication {
    public static final String QUOTE_SVC_URL = "https://api.chucknorris.io/jokes/random";

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate)  {
        return args -> {
            QuoteDTO quote = restTemplate.getForObject(QUOTE_SVC_URL, QuoteDTO.class);
            if (quote != null) {
                log.info(quote.toString());
            } else {
                log.error("Call to web service did not work");
            }
        };
    }
}
