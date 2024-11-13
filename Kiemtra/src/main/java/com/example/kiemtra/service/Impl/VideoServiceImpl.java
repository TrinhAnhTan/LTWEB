package com.example.kiemtra.service.Impl;

import com.example.kiemtra.dao.IVideoDao;
import com.example.kiemtra.dao.Impl.VideoDaoImpl;
import com.example.kiemtra.model.Video;
import com.example.kiemtra.service.IVideoService;

import java.util.List;

public class VideoServiceImpl implements IVideoService {
    private final IVideoDao videoDao = new VideoDaoImpl();

    @Override
    public Video getVideoById(int videoId) {
        return videoDao.getVideoById(videoId);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoDao.getAllVideos();
    }

    @Override
    public void insertVideo(Video video) {
        videoDao.insertVideo(video);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public void deleteVideo(int videoId) {
        videoDao.deleteVideo(videoId);
    }
}
