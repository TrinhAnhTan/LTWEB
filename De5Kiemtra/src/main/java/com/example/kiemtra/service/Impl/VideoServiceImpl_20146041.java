package com.example.kiemtra.service.Impl;

import com.example.kiemtra.entity.Video;
import com.example.kiemtra.service.IVideoService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class VideoServiceImpl_20146041 implements IVideoService {
    private final EntityManagerFactory entityManagerFactory;

    public VideoServiceImpl_20146041() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("kiemtraPU");
    }

    @Override
    public Video getVideoById(int videoId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(Video.class, videoId);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> getAllVideos() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void insertVideo(Video video) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(video);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateVideo(Video video) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();

            // Tải Video từ cơ sở dữ liệu trước khi cập nhật
            Video existingVideo = em.find(Video.class, video.getVideoId());
            if (existingVideo != null) {
                // Cập nhật các trường từ đối tượng được truyền vào
                existingVideo.setTitle(video.getTitle());
                existingVideo.setPoster(video.getPoster());
                existingVideo.setViews(video.getViews());
                existingVideo.setDescription(video.getDescription());
                existingVideo.setActive(video.isActive());

                // Xử lý liên kết Category nếu cần
                if (video.getCategory() != null) {
                    existingVideo.setCategory(em.merge(video.getCategory()));
                }

                // Xử lý các trường liên kết khác nếu có (nếu cần thiết)
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e; // Bắn lại lỗi để thông báo nếu cần
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteVideo(int videoId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            Video video = em.find(Video.class, videoId);
            if (video != null) {
                em.remove(video);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
