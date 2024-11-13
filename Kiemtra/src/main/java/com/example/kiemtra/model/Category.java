package com.example.kiemtra.model;

import lombok.Data;

@Data
public class Category {
    private int categoryId; // Khóa chính tự tăng
    private String categoryName;
    private String categoryCode;
    private String images; // Đường dẫn hình ảnh
    private boolean status; // Sử dụng boolean để đại diện cho trạng thái
}
