package com.aaron.videoplay.controller;

import com.aaron.videoplay.entity.JsonResult;
import com.aaron.videoplay.entity.ResultCode;
import com.aaron.videoplay.entity.VideoInfo;
import com.aaron.videoplay.service.CategoryService;
import com.aaron.videoplay.service.VideoService;
import com.aaron.videoplay.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private VideoService videoService;

    @RequestMapping("getAllCategory")
    public Object getAllCategory(){
        JsonResult result=new JsonResult();
        result.setData(categoryService.getAllCategory());
        return result;
    }
    @RequestMapping("getVideoByCategory")
    public Object getVideoByCategory(@RequestParam("categoryId") Integer categoryId){
        JsonResult result=new JsonResult();
        result.setData(videoService.getVideosByCategory(categoryId));
        return result;
    }
    @RequestMapping("security/getVideoByUser")
    public Object getVideoByUser(@RequestParam("userId") Integer userId){
        JsonResult result=new JsonResult();
        result.setData(videoService.getVideosByUserId(userId));
        return  result;
    }

    @RequestMapping("security/deleteVideo")
    public Object deleteVideo(@RequestParam("videoId") Integer videoId){
        JsonResult result=new JsonResult();
        videoService.deleteById(videoId);
        return result;
    }
    @RequestMapping(value="security/uploadVideo" ,method=RequestMethod.POST)
    public Object uploadVideo(@RequestParam("videoFile") MultipartFile videoFile, VideoInfo videoInfo, HttpServletRequest request){
        JsonResult result=new JsonResult();
        String videoUrl=FileUtils.saveFileToTomcat(videoFile,request.getSession().getServletContext().getRealPath("/"));
        if(videoUrl.equals("上传失败")){
            result.setCode(ResultCode.FAIL);
            result.setMsg("上传失败");
        }else{
            videoInfo.setVideoUrl(videoUrl);
            int id=videoService.insert(videoInfo);
            result.setData(videoInfo);
        }
        return result;
    }


}
