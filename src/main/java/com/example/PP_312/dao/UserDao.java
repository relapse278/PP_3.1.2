package com.example.PP_312.dao;

import com.example.PP_312.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(long id);
    User getUserById(long id);
    List<User> listUsers();
}