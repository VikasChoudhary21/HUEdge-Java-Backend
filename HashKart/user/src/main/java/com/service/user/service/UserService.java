package com.service.user.service;

import java.util.List;
import java.util.Optional;

import com.service.user.entity.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);
    User getUserByName(String userName);
    User saveUser(User user);
}
