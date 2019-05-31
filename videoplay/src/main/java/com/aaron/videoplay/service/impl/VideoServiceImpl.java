package com.aaron.videoplay.service.impl;

import com.aaron.videoplay.entity.VideoCategory;
import com.aaron.videoplay.entity.VideoInfo;
import com.aaron.videoplay.mapper.CategoryMapper;
import com.aaron.videoplay.mapper.VideoMapper;
import com.aaron.videoplay.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<VideoInfo> getVideosByCategory(int category) {
        List<VideoInfo> infos=videoMapper.getVideosByCategory(category);
        VideoCategory category1=categoryMapper.getCategoryById(category);
        for(VideoInfo info:infos){
            info.setVideoCategory(category1);
        }
        return infos;
    }

    @Override
    public List<VideoInfo> getVideosByUserId(int userId) {
        List<VideoInfo> infos=videoMapper.getVideosByUserId(userId);
        List<VideoCategory> categories=categoryMapper.getAllCategory();
        for(VideoInfo info:infos){
            for(VideoCategory category:categories){
                if(category.getCategoryId().equals(info.getVideoCategoryId()));
            }
        }
        return infos;
    }

    @Override
    public int insert(VideoInfo info) {
        return videoMapper.insert(info);
    }

    @Override
    public void deleteById(int videoId) {
        videoMapper.deleteById(videoId);

    }
}
