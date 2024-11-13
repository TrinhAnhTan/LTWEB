package com.example.kiemtra.dao;

import com.example.kiemtra.model.User;

import java.util.List;

public interface IUserDao_20146041 {
    User getUserByUsername(String username);
    Boolean checkUserExists(String username);
    void updateUser(User user);
    void insertUser(User user);
    void deleteUser(String username); // Xóa user theo username (thay vì id)
    List<User> getAllUsers();
}
