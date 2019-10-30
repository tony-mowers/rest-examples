package com.alika.examples.rest.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.Date;

@Data
@AllArgsConstructor
class User {
    private Integer id;
    private String name;
    private Date birthDate;
}
