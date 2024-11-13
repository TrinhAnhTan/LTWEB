package com.example.kiemtra.model;

import lombok.Data;

@Data
public class User {
    private String username; // Khóa chính
    private String password;
    private String phone;
    private String fullname;
    private String email;
    private boolean isAdmin; // Sử dụng boolean thay vì int để đại diện cho trạng thái
    private boolean isActive;
    private String images; // Đường dẫn hình ảnh
}
