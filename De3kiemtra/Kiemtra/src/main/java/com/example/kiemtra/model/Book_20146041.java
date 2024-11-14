package com.example.kiemtra.model;

import lombok.Data;

import java.util.List;

@Data
public class Book_20146041 {
    private int bookId;
    private int isbn;
    private String title;
    private String publisher;
    private double price;
    private String description;
    private java.sql.Date publishDate;
    private String coverImage;
    private int quantity;
    private Author_20146041 author;
    List<Rating_20146041> ratings;

    public Author_20146041 getAuthor() { return author; }
    public void setAuthor(Author_20146041 author) { this.author = author; }
}
