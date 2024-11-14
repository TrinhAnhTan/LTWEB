package com.example.kiemtra.controller;

import com.example.kiemtra.model.Author_20146041;
import com.example.kiemtra.service.IAuthorService_20146041;
import com.example.kiemtra.service.Impl.AuthorService_20146041;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/authors")
public class AuthorController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IAuthorService_20146041 authorService = new AuthorService_20146041(); // Giả sử bạn có một lớp AuthorService để xử lý logic

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author_20146041> authorsWithBooks = authorService.getAuthorsWithBooks();

        // Truyền dữ liệu sang JSP
        req.setAttribute("authors", authorsWithBooks);
        req.getRequestDispatcher("views/web/author-books.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
