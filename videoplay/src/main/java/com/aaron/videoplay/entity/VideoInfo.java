package com.aaron.videoplay.entity;

import java.sql.Timestamp;

public class VideoInfo {
    private Integer videoId;
    private String videoName;
    private String videoDesc;
    private String videoUrl;
    private Integer videoCategoryId;
    private String videoImgUrl;
    private VideoCategory videoCategory;
    private int videoUpUser;
    private Timestamp videoUpTime;

    public Timestamp getVideoUpTime() {
        return videoUpTime;
    }

    public void setVideoUpTime(Timestamp videoUpTime) {
        this.videoUpTime = videoUpTime;
    }

    public int getVideoUpUser() {
        return videoUpUser;
    }

    public void setVideoUpUser(int videoUpUser) {
        this.videoUpUser = videoUpUser;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getVideoCategoryId() {
        return videoCategoryId;
    }

    public void setVideoCategoryId(Integer videoCategoryId) {
        this.videoCategoryId = videoCategoryId;
    }

    public String getVideoImgUrl() {
        return videoImgUrl;
    }

    public void setVideoImgUrl(String videoImgUrl) {
        this.videoImgUrl = videoImgUrl;
    }

    public VideoCategory getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(VideoCategory videoCategory) {
        this.videoCategory = videoCategory;
    }
}
