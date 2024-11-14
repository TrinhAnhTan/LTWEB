package com.example.kiemtra.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User_20146041 {
    private int id;
    private String email;
    private String fullname;
    private String phone;
    private String passwd;
    private LocalDateTime signupDate;
    private LocalDateTime lastLogin;
    private int isAdmin;
}
