package com.alika.examples.rest.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
class User {
    private Integer id;

    @Size(min = 2, message = "User name must have at least two characters")
    private String name;

    @Past( message = "User birthDate must be in the past")
    private Date birthDate;
}
