package com.aaron.videoplay.service.impl;

import com.aaron.videoplay.entity.VideoCategory;
import com.aaron.videoplay.mapper.CategoryMapper;
import com.aaron.videoplay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<VideoCategory> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public VideoCategory getCategoryById(int id) {
        return categoryMapper.getCategoryById(id);
    }
}
