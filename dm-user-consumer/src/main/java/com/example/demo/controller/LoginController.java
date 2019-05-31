package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserFeignClient userFeignClient;
    @RequestMapping(value="/userlogin" ,method=RequestMethod.POST)
    public String login(@RequestBody User user){
//        if(userFeignClient.login(user)){
//            return "hello "+user.getUsername();
//        }else{
//            return "wrong name or pwd";
//        }
        for(int i=0;i<10;i++){
             userFeignClient.login(i);
        }
        return "负载均衡";
    }
}
