package com.eva.userrest.service;

import com.eva.userrest.entity.User;

import java.util.List;

public interface UserService {
    // Create new user.
    void create(User user);

    // Get list of all users.
    List<User> getAll();

    // Get user by id.
    User read(Integer id);

    // Delete user by id.
    boolean delete(Integer id);

}
