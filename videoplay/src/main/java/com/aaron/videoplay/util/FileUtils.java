package com.aaron.videoplay.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
    private static String baseUrl = "http://localhost:8080/upload";
    public static String saveFileToTomcat(MultipartFile file,String realPath) {

        // 获取文件名
        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //加个时间戳，尽量避免文件名称重复

        String path = realPath.substring(0,realPath.length()-11) +File.separator+"upload"+File.separator+ fileName;
        System.out.println(path);
        //创建文件路径
        File dest = new File(path);
        // 判断文件是否已经存在
        if (dest.exists()) {
            System.out.println("文件存在");
            return "上传失败";
        }
        // 判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
             file.transferTo(dest); //保存文件
            return baseUrl + File.separator+fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
    }
}
