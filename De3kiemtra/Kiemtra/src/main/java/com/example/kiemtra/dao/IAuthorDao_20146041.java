package com.example.kiemtra.dao;

import com.example.kiemtra.model.Author_20146041;

import java.util.List;

public interface IAuthorDao_20146041 {
    void insertAuthor(Author_20146041 author);
    Author_20146041 getAuthorById(int id);
    void updateAuthor(Author_20146041 author);
    void deleteAuthor(int id);
    List<Author_20146041> getAuthors(int page, int pageSize);
    public int countAuthors();

    List<Author_20146041> getAuthorsWithBooks();
}
