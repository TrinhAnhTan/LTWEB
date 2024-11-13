package com.example.kiemtra.dao;

import com.example.kiemtra.model.Video;

import java.util.List;

public interface IVideoDao_20146041 {
    Video getVideoById(int videoId);
    List<Video> getAllVideos();
    void insertVideo(Video video);
    void updateVideo(Video video);
    void deleteVideo(int videoId);
}
