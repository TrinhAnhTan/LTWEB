package com.example.kiemtra.dao;

import com.example.kiemtra.model.Category;
import com.example.kiemtra.model.Video;

import java.util.List;
import java.util.Map;

public interface ICategoryDao_20146041 {
    Map<Category, List<Video>> getCategoriesWithVideos();
}
