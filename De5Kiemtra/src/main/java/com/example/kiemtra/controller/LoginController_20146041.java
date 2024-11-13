package com.example.kiemtra.controller;

import com.example.kiemtra.entity.User;
import com.example.kiemtra.service.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("role", user.isAdmin() ? "admin" : "user");
            session.setAttribute("username", user.getUsername());
            session.setAttribute("fullname", user.getFullname());
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác.");
            req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
        }
    }
}
