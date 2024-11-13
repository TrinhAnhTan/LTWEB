package com.example.kiemtra.model;

import lombok.Data;

@Data
public class Video {
    private int videoId;
    private String title;
    private String poster;
    private int views;
    private String description;
    private boolean isActive;
    private int categoryId;
    private int shareCount;

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }
}
