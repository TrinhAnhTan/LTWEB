package com.example.kiemtra.controller;

import com.example.kiemtra.entity.User;
import com.example.kiemtra.service.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setUsername(username);
        user.setPassword(password);
        user.setAdmin(false);
        user.setActive(true);

        userService.insertUser(user);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
