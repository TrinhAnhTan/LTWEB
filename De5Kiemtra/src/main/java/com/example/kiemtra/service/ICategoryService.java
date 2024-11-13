package com.example.kiemtra.service;

import com.example.kiemtra.entity.Category;
import com.example.kiemtra.entity.Video;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
    Map<Category, List<Video>> getCategoriesWithVideos();
}
