package com.example.kiemtra.controller;

import com.example.kiemtra.entity.User;
import com.example.kiemtra.service.IUserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users")
@Controller
public class UserController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            List<User> users = userService.getAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("views/web/user-list.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            String username = req.getParameter("username");
            User user = userService.getUserByUsername(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/web/user-form.jsp").forward(req, resp);
        } else if (action.equals("new")) {
            req.getRequestDispatcher("views/web/user-form.jsp").forward(req, resp);
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
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String fullname = req.getParameter("fullname");
            String email = req.getParameter("email");
            boolean isAdmin = Boolean.parseBoolean(req.getParameter("isAdmin"));

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setFullname(fullname);
            user.setEmail(email);
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
