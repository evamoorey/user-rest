package com.eva.userrest.service;

import com.eva.userrest.entity.User;
import com.eva.userrest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        if (containsId(id)) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public Boolean containsId(Integer id) {
        return userRepository.existsById(id);
    }
}
