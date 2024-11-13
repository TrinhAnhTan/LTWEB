package com.example.kiemtra.dao.Impl;

import com.example.kiemtra.config.ConnectDB;
import com.example.kiemtra.dao.ICategoryDao;
import com.example.kiemtra.model.Category;
import com.example.kiemtra.model.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CategoryDaoImpl_20146041 implements ICategoryDao_20146041 {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public Map<Category, List<Video>> getCategoriesWithVideos() {
        String sql = "SELECT c.categoryId, c.categoryName, c.categoryCode, v.videoId, v.title, v.poster, v.views, v.description, v.active " +
                "FROM category c " + // Sửa "categories" thành "category"
                "LEFT JOIN videos v ON c.categoryId = v.categoryId";
        Map<Category, List<Video>> categoryVideosMap = new LinkedHashMap<>();

        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("categoryName");
                String categoryCode = rs.getString("categoryCode");

                // Tạo đối tượng Category
                Category category = new Category();
                category.setCategoryId(categoryId);
                category.setCategoryName(categoryName);
                category.setCategoryCode(categoryCode);

                // Tạo đối tượng Video nếu có
                Video video = null;
                if (rs.getInt("videoId") != 0) {
                    video = new Video();
                    video.setVideoId(rs.getInt("videoId"));
                    video.setTitle(rs.getString("title"));
                    video.setPoster(rs.getString("poster"));
                    video.setViews(rs.getInt("views"));
                    video.setDescription(rs.getString("description"));
                    video.setActive(rs.getBoolean("active"));
                }

                // Thêm danh mục và video vào map
                categoryVideosMap.computeIfAbsent(category, k -> new ArrayList<>());
                if (video != null) {
                    categoryVideosMap.get(category).add(video);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return categoryVideosMap;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
