package com.example.kiemtra.service;

import com.example.kiemtra.entity.Video;

import java.util.List;

public interface IVideoService {
    Video getVideoById(int videoId);
    List<Video> getAllVideos();
    void insertVideo(Video video);
    void updateVideo(Video video);
    void deleteVideo(int videoId);
}
