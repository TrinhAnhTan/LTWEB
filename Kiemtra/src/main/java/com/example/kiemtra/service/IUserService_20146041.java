package com.example.kiemtra.service;

import com.example.kiemtra.model.User;

import java.util.List;

public interface IUserService_20146041 {
    User getUserByUsername(String username);
    Boolean checkUserExists(String username);
    void updateUser(User user);
    void insertUser(User user);
    void deleteUser(String username);
    List<User> getAllUsers();
}
