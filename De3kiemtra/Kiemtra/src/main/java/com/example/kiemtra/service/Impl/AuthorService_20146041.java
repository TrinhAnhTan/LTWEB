package com.example.kiemtra.service.Impl;

import com.example.kiemtra.dao.IAuthorDao_20146041;
import com.example.kiemtra.dao.Impl.AuthorDao_20146041;
import com.example.kiemtra.model.Author_20146041;
import com.example.kiemtra.service.IAuthorService_20146041;

import java.util.List;

public class AuthorService_20146041 implements IAuthorService_20146041 {
    private final IAuthorDao_20146041 authorDao = new AuthorDao_20146041();
    private static final int PAGE_SIZE = 6;

    @Override
    public void addAuthor(Author_20146041 author) {
        authorDao.insertAuthor(author);
    }

    @Override
    public Author_20146041 findAuthorById(int id) {
        return authorDao.getAuthorById(id);
    }

    @Override
    public void updateAuthor(Author_20146041 author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public void removeAuthor(int id) {
        authorDao.deleteAuthor(id);
    }

    @Override
    public List<Author_20146041> listAuthors(int page) {
        return authorDao.getAuthors(page, PAGE_SIZE);
    }
    @Override
    public int countAuthors() {
        return authorDao.countAuthors(); // Phương thức đếm số lượng tác giả trong cơ sở dữ liệu
    }

    @Override
    public List<Author_20146041> getAuthorsWithBooks() {
        return authorDao.getAuthorsWithBooks();
    }
}
