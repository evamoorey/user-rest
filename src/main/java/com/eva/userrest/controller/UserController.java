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
        userService.add(user);
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
    //@PutMapping (update info) https://spring.io/guides/tutorials/rest/


}

