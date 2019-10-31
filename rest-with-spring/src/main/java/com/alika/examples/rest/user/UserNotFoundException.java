package com.alika.examples.rest.user;

import com.alika.examples.rest.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

class UserNotFoundException extends ObjectNotFoundException {

    UserNotFoundException(String message) {
        super(message);
    }
}
