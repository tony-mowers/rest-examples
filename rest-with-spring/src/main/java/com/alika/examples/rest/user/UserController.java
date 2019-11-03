package com.alika.examples.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final IUserDao userDao;

    @Autowired
    public UserController(IUserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable int id)
    {
        return userDao.getUserById(id);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userDao.deleteUserById(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<URI> createUser(@Valid @RequestBody User user)
    {
        User savedUser = userDao.saveUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
