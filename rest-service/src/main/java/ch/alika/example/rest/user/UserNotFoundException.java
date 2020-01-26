package ch.alika.example.rest.user;

import ch.alika.example.rest.exception.ObjectNotFoundException;

class UserNotFoundException extends ObjectNotFoundException {

    UserNotFoundException(String message) {
        super(message);
    }
}
