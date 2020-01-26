package ch.alika.example.rest.user;

import java.util.List;

public interface IUserDao {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(int id);

    void deleteUserById(int id);
}
