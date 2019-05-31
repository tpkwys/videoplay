package com.aaron.videoplay.mapper;

import com.aaron.videoplay.entity.VideoCategory;
import com.aaron.videoplay.entity.VideoInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {

    List<VideoInfo> getVideosByCategory(@Param("category") int category);

    List<VideoInfo> getVideosByUserId(@Param("userId") int userId);

    int insert(@Param("info")VideoInfo info);

    void deleteById(@Param("videoId")int videoId);


}
