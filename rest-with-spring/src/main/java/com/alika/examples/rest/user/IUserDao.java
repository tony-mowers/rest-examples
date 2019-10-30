package com.alika.examples.rest.user;

import java.util.List;

public interface IUserDao {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUser(int id);
}
