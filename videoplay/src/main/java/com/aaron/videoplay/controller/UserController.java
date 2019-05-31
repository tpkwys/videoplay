package com.aaron.videoplay.controller;

import com.aaron.videoplay.entity.JsonResult;
import com.aaron.videoplay.entity.ResultCode;
import com.aaron.videoplay.entity.User;
import com.aaron.videoplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public Object login(@RequestBody User user, HttpServletRequest request){
        JsonResult jsonResult=new JsonResult();
        //判断账号密码是否正确
        User info=userService.getByNickNameAndPass(user.getNickName(),user.getUserPass());
        if(info==null){
            jsonResult.setCode(ResultCode.WRONG_NICK_PASS);
            jsonResult.setMsg(ResultCode.WRONG_NICK_PASS.msg());
            return jsonResult;
        }
        //判断账号是否在线
        boolean flag=userService.isOn(user.getNickName());
        if(flag){
            jsonResult.setCode(ResultCode.REPEAT_LOGIN);
            jsonResult.setMsg(ResultCode.REPEAT_LOGIN.msg());
            return jsonResult;
        }
        //更新状态,避免同一账号多处在线
        user.setUserPass(null);
        user.setIsOn(1);
        info.setIsOn(1);
        jsonResult.setData(info);
        userService.updateUser(info);
        //在session中缓存用户信息 24小时
        HttpSession session =request.getSession();
        session.setAttribute("user",info);

        return jsonResult;
    }

    @RequestMapping("logout")
    public Object logout(@RequestBody User user,HttpServletRequest request){
        JsonResult result=new JsonResult();
        HttpSession session=request.getSession();
        User info=(User)session.getAttribute("user");
        if(info!=null&&info.getNickName().equals(user.getNickName())){
            user.setIsOn(0);
            userService.updateUser(user);
            //清空session中缓存的用户信息
            Enumeration em = request.getSession().getAttributeNames();
            while(em.hasMoreElements()){
                request.getSession().removeAttribute(em.nextElement().toString());
            }
            session.invalidate();
        }
        return result;
    }

    @RequestMapping("registry")
    public Object registry(@RequestBody User user){
        JsonResult result=new JsonResult();
        Integer id=userService.registryUser(user);
        result.setData(id);
        result.setData(id);
        return result;
    }
    @RequestMapping("checkName")
    public Object checkName(@RequestParam String  userName){
        return userService.isExistNickName(userName);
    }
}
