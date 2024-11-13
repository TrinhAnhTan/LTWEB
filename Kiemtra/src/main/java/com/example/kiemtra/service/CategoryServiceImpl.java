package com.example.kiemtra.service.Impl;

import com.example.kiemtra.dao.ICategoryDao;
import com.example.kiemtra.dao.Impl.CategoryDaoImpl;
import com.example.kiemtra.model.Category;
import com.example.kiemtra.model.Video;
import com.example.kiemtra.service.ICategoryService;

import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public Map<Category, List<Video>> getCategoriesWithVideos() {
        return categoryDao.getCategoriesWithVideos();
    }
}
