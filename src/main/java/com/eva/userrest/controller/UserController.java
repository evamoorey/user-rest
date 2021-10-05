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
    public @ResponseBody String getUserById(@PathVariable Integer id) {
        if (id > userService.getAll().size()) {
            return "Error! Database doesn't have user with this id.";
        }
        return userService.read(id).toString();
    }

    @PostMapping("/user")
    public @ResponseBody String addUser(@RequestBody User user) {
        userService.add(user);
        return "User added successfully!";
    }

    //@DeleteMapping
    //@PutMapping (update info) https://spring.io/guides/tutorials/rest/


}

