package com.eva.userrest.controller;

import com.eva.userrest.entity.User;
import com.eva.userrest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> usersData() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Integer id) {
        if (!userService.containsId(id)) {
            //return "Error! Database doesn't have user with this id.";
        }
        return userService.read(id);
    }

    @PostMapping("/user/new")
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @GetMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        if (userService.containsId(id)) {
            userService.delete(id);
            //return "User with id = " + id + " deleted successfully!";
        }
        //return "Error! Database doesn't have user with this id.";
    }

    @PutMapping("user/update/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        if (userService.containsId(id)) {
            userService.read(id).setName(user.getName());
            userService.read(id).setInfo(user.getInfo());
            userService.save(userService.read(id));
            return user;
        }
        return user;
    }
}

