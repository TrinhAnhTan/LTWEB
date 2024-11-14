package com.example.kiemtra.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Author_20146041 {
    private int authorId;
    private String authorName;
    private Date dateOfBirth;

    private List<Book_20146041> books = new ArrayList<>();
}
