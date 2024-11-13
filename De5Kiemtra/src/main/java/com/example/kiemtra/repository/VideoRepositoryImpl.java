package com.example.kiemtra.repository;

import com.example.kiemtra.entity.Video;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class VideoRepositoryImpl implements VideoRepository {
    private final EntityManagerFactory entityManagerFactory;

    public VideoRepositoryImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("kiemtraPU");
    }

    @Override
    public Video findById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(Video.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void save(Video video) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            if (video.getVideoId() == 0) {
                em.persist(video);
            } else {
                em.merge(video);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            Video video = em.find(Video.class, id);
            if (video != null) {
                em.remove(video);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
