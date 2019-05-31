package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserService {
    private Logger logger=LoggerFactory.getLogger(UserService.class);

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam("count") int count)  throws  Exception{
        logger.info("provider service 8080:"+count);
        return "用户已经验证";
    }
//    public Boolean login(@RequestBody User user) throws  Exception{
//        return "admin".equals(user.getUsername())&&"admin".equals(user.getPassword());
//    }
//    public Boolean login(@RequestParam("name") String name,@RequestParam("pwd") String pwd) throws  Exception{
//        return "admin".equals(name)&&"admin".equals(pwd);
//    }
}
