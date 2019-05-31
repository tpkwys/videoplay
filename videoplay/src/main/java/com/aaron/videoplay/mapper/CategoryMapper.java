package com.aaron.videoplay.mapper;

import com.aaron.videoplay.entity.VideoCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<VideoCategory> getAllCategory();
    VideoCategory getCategoryById(@Param("id") int id);
}
