package com.example.kiemtra.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xóa session của người dùng để đăng xuất
        request.getSession().invalidate();

        // Chuyển hướng về trang đăng nhập hoặc trang chủ
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
