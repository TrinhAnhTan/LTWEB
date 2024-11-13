package com.example.kiemtra.service.Impl;

import com.example.kiemtra.entity.Category;
import com.example.kiemtra.entity.Video;
import com.example.kiemtra.service.ICategoryService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl_20146041 implements ICategoryService {
    private final EntityManagerFactory entityManagerFactory;

    public CategoryServiceImpl_20146041() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("kiemtraPU");
    }

    @Override
    public List<Category> getAllCategories() {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Category getCategoryById(int categoryId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(Category.class, categoryId);
        } finally {
            em.close();
        }
    }

    @Override
    public Map<Category, List<Video>> getCategoriesWithVideos() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Map<Category, List<Video>> categoryVideosMap = new LinkedHashMap<>();
        try {
            // Lấy danh sách danh mục và tải video tương ứng
            List<Category> categories = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();

            // Tạo map cho mỗi danh mục với danh sách video
            for (Category category : categories) {
                List<Video> videos = em.createQuery(
                                "SELECT v FROM Video v WHERE v.category = :category", Video.class)
                        .setParameter("category", category)
                        .getResultList();
                categoryVideosMap.put(category, videos);
            }
        } finally {
            em.close();
        }
        return categoryVideosMap;
    }

}
