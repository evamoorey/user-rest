package com.eva.userrest.service;

import com.eva.userrest.entity.User;

import java.util.List;

public interface UserService {
    // Save user.
    void save(User user);

    // Get list of all users.
    List<User> getAll();

    // Get user by id.
    User read(Integer id);

    // Delete user by id.
    void delete(Integer id);
}
