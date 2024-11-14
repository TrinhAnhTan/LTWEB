package com.example.kiemtra.model;

import lombok.Data;

@Data
public class Rating_20146041 {
    private int userId;
    private int bookId;
    private int rating;
    private String reviewText;
    private String fullname;
    public void setUserFullName(String fullname) {
        this.fullname = fullname;
    }
}
