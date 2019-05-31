package com.aaron.videoplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@MapperScan(basePackages = "com.aaron.videoplay.mapper")
@ComponentScan("com.aaron.videoplay.*")
@ServletComponentScan(basePackages="com.aaron.videoplay.*")
public class VideoplayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VideoplayApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //设置session过期时间  很怪：配置yml sesion timeout 和 session.setMaxInactiveInterval(5);无效
        servletContext.setSessionTimeout(60*24*24);
        super.onStartup(servletContext);
    }
}
