package com.alika.examples.rest.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDao implements IUserDao {

    private List<User> users = new ArrayList<>();
    private int userCount = 0;

    public UserDao() {
        users.add(new User(++userCount,"Tony Mowers", new Date()));
        users.add(new User(++userCount,"Roxane Mowers", new Date()));
        users.add(new User(++userCount,"Sheryl Mowers", new Date()));
        users.add(new User(++userCount,"Dannie Mowers", new Date()));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User saveUser(User user) {
        if (user.getId() != null)
            return user;

        user.setId(++userCount);
        users.add(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        for (User user: users) {
            if (user.getId() == id)
                return user;
        }

        throw new UserNotFoundException(String.format("User object not found [id = %s]",id));
    }
}
