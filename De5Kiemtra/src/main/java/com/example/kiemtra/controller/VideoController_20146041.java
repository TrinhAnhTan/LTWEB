package com.example.kiemtra.controller;

import com.example.kiemtra.entity.Category;
import com.example.kiemtra.entity.Video;
import com.example.kiemtra.service.ICategoryService;
import com.example.kiemtra.service.IVideoService;
import com.example.kiemtra.service.Impl.CategoryServiceImpl_20146057;
import com.example.kiemtra.service.Impl.VideoServiceImpl_20146057;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/videos")
public class VideoController_20146041 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private IVideoService videoService;
    private ICategoryService categoryService;

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl_20146057();
        categoryService = new CategoryServiceImpl_20146057();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null || action.equals("list")) {
            List<Video> videos = videoService.getAllVideos();
            req.setAttribute("videos", videos);
            req.getRequestDispatcher("views/web/video-list.jsp").forward(req, resp);
        } else if (action.equals("details")) {
            int videoId = Integer.parseInt(req.getParameter("videoId"));
            Video video = videoService.getVideoById(videoId);
            if (video == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Video không tồn tại");
                return;
            }
            req.setAttribute("video", video);
            req.getRequestDispatcher("views/web/video-details.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            int videoId = Integer.parseInt(req.getParameter("videoId"));
            Video video = videoService.getVideoById(videoId);
            List<Category> categories = categoryService.getAllCategories();
            req.setAttribute("categories", categories);
            req.setAttribute("video", video);
            req.getRequestDispatcher("views/web/video-form.jsp").forward(req, resp);
        } else if (action.equals("new")) {
            List<Category> categories = categoryService.getAllCategories();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("views/web/video-form.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            int videoId = Integer.parseInt(req.getParameter("videoId"));
            videoService.deleteVideo(videoId);
            resp.sendRedirect(req.getContextPath() + "/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("save")) {
            String videoIdParam = req.getParameter("videoId");
            int videoId = (videoIdParam != null && !videoIdParam.trim().isEmpty()) ? Integer.parseInt(videoIdParam) : 0;

            String title = req.getParameter("title");
            String poster = req.getParameter("poster");
            int views = Integer.parseInt(req.getParameter("views"));
            String description = req.getParameter("description");
            String activeParam = req.getParameter("active");

            // Thiết lập giá trị mặc định là true nếu không có dữ liệu được gửi
            boolean active = (activeParam != null) ? Boolean.parseBoolean(activeParam) : true;

            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            Category category = categoryService.getCategoryById(categoryId);

            Video video = new Video();
            video.setVideoId(videoId);
            video.setTitle(title);
            video.setPoster(poster);
            video.setViews(views);
            video.setDescription(description);
            video.setActive(true);
            video.setCategory(category);

            if (videoId == 0) {
                videoService.insertVideo(video);
            } else {
                videoService.updateVideo(video);
            }

            resp.sendRedirect(req.getContextPath() + "/videos");
        }
    }
}
