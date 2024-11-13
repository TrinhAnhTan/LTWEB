package com.example.kiemtra.service;

import com.example.kiemtra.model.Category;
import com.example.kiemtra.model.Video;

import java.util.List;
import java.util.Map;

public interface ICategoryService {
    Map<Category, List<Video>> getCategoriesWithVideos();
}
