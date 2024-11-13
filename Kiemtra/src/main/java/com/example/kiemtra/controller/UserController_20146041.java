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
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final IUserService_20146041 userService = new UserService_20146041();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            List<User> users = userService_20146041.getAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("views/web/video-list.jsp").forward(req, resp);

        } else if (action.equals("edit")) {
            String username = req.getParameter("username");
            User user = userService.getUserByUsername(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/web/video-form.jsp").forward(req, resp);

        } else if (action.equals("new")) {
            req.getRequestDispatcher("views/web/video-form.jsp").forward(req, resp);

        } else if (action.equals("delete")) {
            String username = req.getParameter("username");
            userService.deleteUser(username);
            resp.sendRedirect(req.getContextPath() + "/users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("save")) {
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String fullname = req.getParameter("fullname");
            String phone = req.getParameter("phone");
            String password = req.getParameter("password");
            boolean isAdmin = Boolean.parseBoolean(req.getParameter("isAdmin"));

            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setFullname(fullname);
            user.setPhone(phone);
            user.setPassword(password);
            user.setAdmin(isAdmin);
            user.setActive(true);

            if (userService.checkUserExists(username)) {
                userService.updateUser(user);
            } else {
                userService.insertUser(user);
            }

            resp.sendRedirect(req.getContextPath() + "/users");
        }
    }
}
