package com.eva.userrest.controller;

import com.eva.userrest.entity.User;
import com.eva.userrest.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return Optional.ofNullable(userService.read(id))
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        User newUser = Optional.of(userService.read(id)).orElse(user);
        newUser.setInfo(user.getInfo());
        newUser.setName(user.getInfo());
        userService.save(newUser);
        return user;
    }
}

