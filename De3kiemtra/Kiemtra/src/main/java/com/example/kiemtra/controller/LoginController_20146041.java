package com.example.kiemtra.controller;

import com.example.kiemtra.model.User_20146041;
import com.example.kiemtra.service.IUserService_20146041;
import com.example.kiemtra.service.Impl.UserService_20146041;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService_20146041 userService = new UserService_20146041(); // Giả sử bạn có một lớp UserService để xử lý logic

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Gọi UserService để kiểm tra người dùng
        User_20146041 user = userService.getUserByEmail(email);

        if (user != null && user.getPasswd().equals(password)) {
            // Lưu thông tin user vào session khi đăng nhập thành công
            HttpSession session = req.getSession();
            if(user.getIsAdmin()==1) {
                session.setAttribute("admin", "admin");
            }
            session.setAttribute("userId", user.getId()); // lưu userId vào session
            session.setAttribute("fullname", user.getFullname()); // lưu tên của người dùng vào session (tuỳ chọn)

            // Chuyển hướng đến trang chủ hoặc trang người dùng
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            // Nếu đăng nhập không thành công, hiển thị thông báo lỗi
            req.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác.");
            req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);
        }
    }

}
