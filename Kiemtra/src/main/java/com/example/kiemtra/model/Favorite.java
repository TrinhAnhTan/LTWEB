package com.example.kiemtra.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Favorite {
    private int favoriteId; // Khóa chính tự tăng
    private LocalDate likedDate; // Ngày thích video
    private int videoId; // Khóa ngoại tới Videos
    private String username; // Khóa ngoại tới Users
}
