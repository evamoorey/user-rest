package com.eva.userrest.controller;


import com.eva.userrest.entity.User;

import java.util.List;

public interface UserController {
    // Get all users.
    List<User> usersData();

    // Get user by id from DB.
    User getUserById(Integer id);

    // Add new user.
    User addUser(User user);

    // Delete user by id.
    void deleteUser(Integer id);

    // Update user's info.
    User updateUser(Integer id, User user);
}
