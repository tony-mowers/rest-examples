package com.alika.examples.rest.somebean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SomeBeanController {

    @GetMapping("/somebean")
    public SomeBean getSomeBean() {
        return new SomeBean("value1", "value2","value3");
    }

    @GetMapping("/somebeans")
    public List<SomeBean> getSomeBeans() {
        return Arrays.asList(
                new SomeBean("value11", "value12","value13"),
                new SomeBean("value21", "value22","value23")
        );
    }

    @Value
    private static class SomeBean {
        private String value1;
        private String value2;
        @JsonIgnore
        private String value3;
    }
}
