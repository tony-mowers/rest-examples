package com.alika.examples.rest.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@ApiModel(description = "An entity representing a person who can own resources")
class User {
    private Integer id;

    @ApiModelProperty(notes="Name must have at least two characters")
    @Size(min = 2, message = "User name must have at least two characters")
    private String name;

    @ApiModelProperty(notes="Birth date must be in the past")
    @Past( message = "User birthDate must be in the past")
    private Date birthDate;
}
