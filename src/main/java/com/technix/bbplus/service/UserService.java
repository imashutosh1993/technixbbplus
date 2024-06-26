package com.technix.bbplus.service;

import com.technix.bbplus.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User updateUser(int id, User user);

    boolean deleteUser(int id);

    List<User> getBycustomerId(int CustomerId);


}
