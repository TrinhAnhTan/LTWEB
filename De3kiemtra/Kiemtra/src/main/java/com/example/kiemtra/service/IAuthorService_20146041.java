package com.example.kiemtra.service;

import com.example.kiemtra.model.Author_20146041;

import java.util.List;

public interface IAuthorService_20146041 {
    void addAuthor(Author_20146041 author);
    Author_20146041 findAuthorById(int id);
    void updateAuthor(Author_20146041 author);
    void removeAuthor(int id);
    List<Author_20146041> listAuthors(int page);
    public int countAuthors();

    List<Author_20146041> getAuthorsWithBooks();
}
