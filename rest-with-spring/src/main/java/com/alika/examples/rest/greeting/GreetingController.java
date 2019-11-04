package com.alika.examples.rest.greeting;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class GreetingController {

    private MessageSource messageSource;

    @Autowired
    public GreetingController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/greeting")
    public Greeting hello(
            @RequestHeader(name="Accept-Language",required = false) Locale locale,
            @RequestParam(value = "name", defaultValue = "World") String name)
    {
        final String message = messageSource.getMessage("hello.message", null, locale);
        return new Greeting(String.format(message,name));
    }

    @GetMapping(path = "/greeting/{name}")
    public Greeting helloWithPathVariable(
            @RequestHeader(name="Accept-Language",required = false) Locale locale,
            @PathVariable String name
    ) {
        final String message = messageSource.getMessage("hello.message", null, locale);
        return new Greeting(String.format(message,name));
    }

    @Value
    private static class Greeting {
        private String message;
    }
}
