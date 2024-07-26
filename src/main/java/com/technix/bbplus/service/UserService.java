package com.technix.bbplus.service;

import com.technix.bbplus.dto.PageResponse;
import com.technix.bbplus.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(int id);

    PageResponse<User> getAllUsers(int page,int size);

    User updateUser(int id, User user);

    boolean deleteUser(int id);

    List<User> getBycustomerId(int CustomerId);


}
