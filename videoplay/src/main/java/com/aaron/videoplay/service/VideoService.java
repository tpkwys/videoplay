package com.aaron.videoplay.service;

import com.aaron.videoplay.entity.User;
import com.aaron.videoplay.entity.VideoInfo;

import java.util.List;

public interface VideoService {
    List<VideoInfo> getVideosByCategory(int category);

    List<VideoInfo> getVideosByUserId(int userId);

    int insert(VideoInfo info);

    void deleteById(int videoId);
}
