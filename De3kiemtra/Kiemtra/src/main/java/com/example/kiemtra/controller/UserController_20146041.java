package com.example.kiemtra.controller;

import com.example.kiemtra.model.User_20146041;
import com.example.kiemtra.service.IUserService_20146041;
import com.example.kiemtra.service.Impl.UserService_20146041;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final IUserService_20146041 userService = new UserService_20146041();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            // Hiển thị danh sách user
            List<User_20146041> users = userService.getAllUsers(); // Implement trong UserService
            req.setAttribute("users", users);
            req.getRequestDispatcher("views/web/user-list.jsp").forward(req, resp);

        } else if (action.equals("edit")) {
            // Hiển thị form chỉnh sửa user
            int userId = Integer.parseInt(req.getParameter("id"));
            User_20146041 user = userService.getUserById(userId);
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/web/user-form.jsp").forward(req, resp);

        } else if (action.equals("new")) {
            // Hiển thị form thêm user mới
            req.getRequestDispatcher("views/web/user-form.jsp").forward(req, resp);
        }
        else if (action.equals("delete")) {
            // Xử lý xóa user
            int userId = parseIntegerOrDefault(req.getParameter("id"), 0);
            System.out.println("Deleting user with ID: " + userId);
            userService.deleteUser(userId);
            System.out.println("Redirecting to /users after deletion");
            resp.sendRedirect(req.getContextPath() + "/users");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("save")) {
            // Lưu hoặc cập nhật user
            int userId = parseIntegerOrDefault(req.getParameter("id"), 0);
            String email = req.getParameter("email");
            String fullname = req.getParameter("fullname");
            String phone = req.getParameter("phone");
            String passwd = req.getParameter("passwd");
            int isAdmin = parseIntegerOrDefault(req.getParameter("isAdmin"), 0);

            User_20146041 user = new User_20146041();
            user.setId(userId);
            user.setEmail(email);
            user.setFullname(fullname);
            user.setPhone(phone);
            user.setPasswd(passwd);
            user.setSignupDate(LocalDateTime.now());
            user.setIsAdmin(isAdmin);

            if (userId == 0) {
                userService.insertUser(user); // Thêm user mới
            } else {
                userService.updateUser(user); // Cập nhật user
            }
            resp.sendRedirect(req.getContextPath() + "/users");
        }
    }
    private int parseIntegerOrDefault(String param, int defaultValue) {
        try {
            return param != null && !param.trim().isEmpty() ? Integer.parseInt(param) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
