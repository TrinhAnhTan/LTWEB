package com.example.kiemtra.controller;

import com.example.kiemtra.model.User;
import com.example.kiemtra.service.IUserService_22110427;
import com.example.kiemtra.service.Impl.UserService_22110427;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService_20146041 userService = new UserService_20146041();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (!password.equals(confirmPassword)) {
            req.setAttribute("errorMessage", "Mật khẩu và xác nhận mật khẩu không khớp.");
            req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setAdmin(false);
        user.setActive(true);

        userService.insertUser(user);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
