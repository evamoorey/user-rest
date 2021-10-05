package com.eva.userrest.service;

import com.eva.userrest.entity.User;

import java.util.List;

public interface UserService {
    // Add new user.
    void add(User user);

    // Get list of all users.
    List<User> getAll();

    // Get user by id.
    User read(Integer id);

    // Delete user by id.
    void delete(Integer id);

    // Check that DB has current id.
    Boolean containsId(Integer id);

}
