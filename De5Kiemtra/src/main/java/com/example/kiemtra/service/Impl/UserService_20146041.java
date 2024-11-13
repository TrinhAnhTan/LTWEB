package com.example.kiemtra.service.Impl;

import com.example.kiemtra.entity.User;
import com.example.kiemtra.repository.UserRepository;
import com.example.kiemtra.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService_20146041 implements IUserService {
    private final UserRepository userRepository;

    public UserService_20146041(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Boolean checkUserExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
