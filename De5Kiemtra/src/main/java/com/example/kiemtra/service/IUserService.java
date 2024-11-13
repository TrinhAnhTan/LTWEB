package com.example.kiemtra.service;

import com.example.kiemtra.entity.User;

import java.util.List;

public interface IUserService {
    User getUserByUsername(String username);
    Boolean checkUserExists(String username);
    void updateUser(User user);
    void insertUser(User user);
    void deleteUser(String username);
    List<User> getAllUsers();
}
