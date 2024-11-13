package com.example.kiemtra.repository;

import com.example.kiemtra.entity.Video;

import java.util.List;

public interface VideoRepository {
    Video findById(int id);
    List<Video> findAll();
    void save(Video video);
    void deleteById(int id);
}
