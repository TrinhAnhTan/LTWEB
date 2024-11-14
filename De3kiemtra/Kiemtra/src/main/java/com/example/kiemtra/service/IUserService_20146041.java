package com.example.kiemtra.service;

import com.example.kiemtra.model.User_20146041;

import java.util.List;

public interface IUserService_20146041 {
    User_20146041 getUserById(int id);
    User_20146041 getUserByEmail(String email);
    Boolean checkUserExists(String username);
    void updateUser(User_20146041 user);
    void insertUser(User_20146041 user);
    void deleteUser(int id);

    List<User_20146041> getAllUsers();
}
