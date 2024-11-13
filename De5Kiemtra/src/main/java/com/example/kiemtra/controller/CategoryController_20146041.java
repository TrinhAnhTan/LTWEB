package com.example.kiemtra.controller;

import com.example.kiemtra.entity.Category;
import com.example.kiemtra.entity.Video;
import com.example.kiemtra.service.ICategoryService;
import com.example.kiemtra.service.Impl.CategoryServiceImpl_20146057;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/categories")
public class CategoryController_20146057 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ICategoryService categoryService;

    @Override
    public void init() throws ServletException {
        categoryService = new CategoryServiceImpl_20146057(); // Khởi tạo thủ công
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy danh mục và video
        Map<Category, List<Video>> categoryVideosMap = categoryService.getCategoriesWithVideos();

        for (Map.Entry<Category, List<Video>> entry : categoryVideosMap.entrySet()) {
            System.out.println("Category: " + entry.getKey().getCategoryName());
            for (Video video : entry.getValue()) {
                System.out.println("Video: " + video.getTitle());
            }
        }
        // Gán vào request và chuyển đến trang JSP
        req.setAttribute("categoryVideosMap", categoryVideosMap);
        req.getRequestDispatcher("views/web/categories.jsp").forward(req, resp);
    }
}
