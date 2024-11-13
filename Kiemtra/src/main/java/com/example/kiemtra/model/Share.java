package com.example.kiemtra.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Share {
    private int shareId; // Khóa chính tự tăng
    private String emails; // Danh sách email chia sẻ
    private LocalDate sharedDate; // Ngày chia sẻ
    private String username; // Khóa ngoại tới Users
    private int videoId; // Khóa ngoại tới Videos
}
