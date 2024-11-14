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

@WebServlet(urlPatterns = "/register")
public class RegisterController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService_20146041 userService = new UserService_20146041(); // Giả sử bạn có một lớp UserService để xử lý logic

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy thông tin người dùng từ form
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String passwd = req.getParameter("passwd");
        String confirmPassword = req.getParameter("confirmPassword");

        // Kiểm tra xem mật khẩu có khớp không
        if (!passwd.equals(confirmPassword)) {
            req.setAttribute("errorMessage", "Mật khẩu và xác nhận mật khẩu không khớp.");
            req.getRequestDispatcher("views/web/register.jsp").forward(req, resp);
            return;
        }

        // Tạo đối tượng User
        User_20146041 user = new User_20146041();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPasswd(passwd);
        user.setSignupDate(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setIsAdmin(0);  // Mặc định là người dùng bình thường, có thể thay đổi sau

        // Gọi phương thức insertUser để lưu thông tin người dùng
        userService.insertUser(user);

        // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
