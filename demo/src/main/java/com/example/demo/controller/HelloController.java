package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {
//    @Autowired
//    private FilterRegistrationBean registration;

    @RequestMapping("/hello")
    public String index(){
        return "hello world";
    }
    @RequestMapping("/getUser")
    public User getUser(){
        User user=new User();
        user.setName("ming");
        user.setPassword("123");
        return user;
    }
//    @RequestMapping("/getName")
//    public Map<String,String> getName(){
//        Map<String,String> initPara=registration.getInitParameters();
//
//        return initPara;
//    }
}
