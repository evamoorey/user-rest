package com.eva.userrest.controller;

import com.eva.userrest.entity.User;
import com.eva.userrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String usersData() {
        return userService.getAll().toString();
    }

    @GetMapping("{id}")
    public @ResponseBody
    String getUserById(@PathVariable Integer id) {
        if (!userService.containsId(id)) {
            return "Error! Database doesn't have user with this id.";
        }
        return userService.read(id).toString();
    }

    @PostMapping("/user/new")
    public @ResponseBody
    String addUser(@RequestBody User user) {
        userService.save(user);
        return "User added successfully!";
    }

    @GetMapping("user/delete/{id}")
    public @ResponseBody
    String deleteUser(@PathVariable Integer id) {
        if (userService.containsId(id)) {
            userService.delete(id);
            return "User with id = " + id + " deleted successfully!";
        }
        return "Error! Database doesn't have user with this id.";
    }

    @PutMapping("user/update/{id}")
    public @ResponseBody
    String updateUser(@PathVariable Integer id, @RequestBody User user) {
        if (userService.containsId(id)) {
            userService.read(id).setName(user.getName());
            userService.read(id).setInfo(user.getInfo());
            userService.save(userService.read(id));
            return "User with id = " + id + " changed successfully!";
        }
        return "Error! Database doesn't have user with this id.";
    }
}

