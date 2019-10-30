package com.alika.examples.rest.greeting;

import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(path = "/greeting")
    public Greeting hello(
            @RequestParam(value = "name", defaultValue = "World") String name
    ) {
        return new Greeting(String.format("Hello %s!",name));
    }

    @GetMapping(path = "/greeting/{name}")
    public Greeting helloWithPathVariable(
            @PathVariable String name
    ) {
        return new Greeting(String.format("Hello %s!",name));
    }

    @Value
    private static class Greeting {
        private String message;
    }
}
