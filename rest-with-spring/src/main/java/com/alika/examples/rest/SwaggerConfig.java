package com.alika.examples.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final Contact CONTACT = new Contact(
            "Tony the Programmer",
            "https://www.tonytheprogrammer.com",
            "");
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "AWESOME API Title",
            "AWESOME Api Description",
            "1.0",
            "urn:tos",
            CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }
}
