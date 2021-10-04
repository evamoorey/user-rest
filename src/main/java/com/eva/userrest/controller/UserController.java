package com.eva.userrest.controller;

import com.eva.userrest.entity.User;
import com.eva.userrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;


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
    public User getUserById(@PathVariable Integer id) {
        if (id > userService.getAll().size()) {
            System.out.println("Error!\nDatabase doesn't have user with this id.");
            //реализовать вывод текста в веб
            return null;
        }
        return userService.read(id);
    }


}

