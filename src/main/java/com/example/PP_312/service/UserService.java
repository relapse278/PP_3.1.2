package com.example.PP_312.service;

import com.example.PP_312.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(long id);
    User getUserById(long id);
    List<User> listUsers();
}