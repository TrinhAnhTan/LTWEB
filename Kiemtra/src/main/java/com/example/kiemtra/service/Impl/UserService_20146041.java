package com.example.kiemtra.service.Impl;

import com.example.kiemtra.dao.IUserDao_22110427;
import com.example.kiemtra.dao.Impl.UserDao_22110427;
import com.example.kiemtra.model.User;
import com.example.kiemtra.service.IUserService_22110427;

import java.util.List;

public class UserService_20146041 implements IUserService_20146041{
    private final IUserDao_20146041 userDao = new UserDao_20146041();

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public Boolean checkUserExists(String username) {
        return userDao.checkUserExists(username);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userDao.deleteUser(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
