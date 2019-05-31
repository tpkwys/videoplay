package com.aaron.videoplay.service;

import com.aaron.videoplay.entity.VideoCategory;

import java.util.List;

public interface CategoryService {
    List<VideoCategory> getAllCategory();
    VideoCategory getCategoryById(int id);
}
