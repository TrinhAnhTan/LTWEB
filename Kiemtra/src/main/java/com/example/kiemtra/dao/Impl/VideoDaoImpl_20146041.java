package com.example.kiemtra.dao.Impl;

import com.example.kiemtra.config.ConnectDB;
import com.example.kiemtra.dao.IVideoDao;
import com.example.kiemtra.model.Video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDaoImpl_20146041 implements IVideoDao_20146041 {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public Video getVideoById(int videoId) {
        String sql = "SELECT v.*, COUNT(s.shareId) AS shareCount " +
                "FROM videos v " +
                "LEFT JOIN shares s ON v.videoId = s.videoId " +
                "WHERE v.videoId = ? " +
                "GROUP BY v.videoId";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, videoId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Video video = new Video();
                video.setVideoId(rs.getInt("videoId"));
                video.setTitle(rs.getString("title"));
                video.setPoster(rs.getString("poster"));
                video.setViews(rs.getInt("views"));
                video.setDescription(rs.getString("description"));
                video.setActive(rs.getBoolean("active"));
                video.setCategoryId(rs.getInt("categoryId"));
                video.setShareCount(rs.getInt("shareCount")); // Gán giá trị shareCount
                return video;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public List<Video> getAllVideos() {
        List<Video> videos = new ArrayList<>();
        String sql = "SELECT * FROM videos";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Video video = new Video();
                video.setVideoId(rs.getInt("videoId"));
                video.setTitle(rs.getString("title"));
                video.setPoster(rs.getString("poster"));
                video.setViews(rs.getInt("views"));
                video.setDescription(rs.getString("description"));
                video.setActive(rs.getBoolean("active"));
                video.setCategoryId(rs.getInt("categoryId"));
                videos.add(video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return videos;
    }

    @Override
    public void insertVideo(Video video) {
        String sql = "INSERT INTO videos (title, poster, views, description, active, categoryId) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, video.getTitle());
            ps.setString(2, video.getPoster());
            ps.setInt(3, video.getViews());
            ps.setString(4, video.getDescription());
            ps.setBoolean(5, video.isActive());
            ps.setInt(6, video.getCategoryId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void updateVideo(Video video) {
        String sql = "UPDATE videos SET title = ?, poster = ?, views = ?, description = ?, active = ?, categoryId = ? WHERE videoId = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, video.getTitle());
            ps.setString(2, video.getPoster());
            ps.setInt(3, video.getViews());
            ps.setString(4, video.getDescription());
            ps.setBoolean(5, video.isActive());
            ps.setInt(6, video.getCategoryId());
            ps.setInt(7, video.getVideoId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void deleteVideo(int videoId) {
        String sql = "DELETE FROM videos WHERE videoId = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, videoId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
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
