package ch.alika.example.rest.somebean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Value;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SomeBeanController {

    private static final String SOME_BEAN_FILTER = "SomeBeanFilter";

    @GetMapping("/somebean")
    public MappingJacksonValue getSomeBean() {
        final SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(getSomeBeanFilter("value2"));
        return mapping;
    }

    @GetMapping("/somebeans")
    public MappingJacksonValue getSomeBeans() {
        final List<SomeBean> someBeans = Arrays.asList(
                new SomeBean("value11", "value12", "value13"),
                new SomeBean("value21", "value22", "value23")
        );
        MappingJacksonValue mapping = new MappingJacksonValue(someBeans);
        mapping.setFilters(getSomeBeanFilter("value1"));
        return mapping;
    }

    private SimpleFilterProvider getSomeBeanFilter(String... propertyNames) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertyNames);
        return new SimpleFilterProvider().addFilter(SOME_BEAN_FILTER ,filter);
    }

    @JsonFilter(SOME_BEAN_FILTER)
    @Value
    private static class SomeBean {
        private String value1;
        private String value2;
        @JsonIgnore
        private String value3;
    }
}
