package com.example.kiemtra.service.Impl;

import com.example.kiemtra.dao.IUserDao_20146041;
import com.example.kiemtra.dao.Impl.UserDao_20146041;
import com.example.kiemtra.model.User_20146041;
import com.example.kiemtra.service.IUserService_20146041;

import java.util.List;

public class UserService_20146041 implements IUserService_20146041 {
    private final IUserDao_20146041 userDao = new UserDao_20146041();

    @Override
    public User_20146041 getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User_20146041 getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public Boolean checkUserExists(String username) {
        return userDao.checkUserExists(username);
    }

    @Override
    public void updateUser(User_20146041 user) {
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(User_20146041 user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User_20146041> getAllUsers() {
        return userDao.getAllUsers();
    }
}
