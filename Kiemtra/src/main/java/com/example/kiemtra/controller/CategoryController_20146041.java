package com.example.kiemtra.controller;

import com.example.kiemtra.model.Category;
import com.example.kiemtra.model.Video;
import com.example.kiemtra.service.ICategoryService;
import com.example.kiemtra.service.Impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/categories")
public class CategoryController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Category, List<Video>> categoryVideosMap = categoryService.getCategoriesWithVideos();
        req.setAttribute("categoryVideosMap", categoryVideosMap);
        req.getRequestDispatcher("views/web/categories.jsp").forward(req, resp);
    }
}
