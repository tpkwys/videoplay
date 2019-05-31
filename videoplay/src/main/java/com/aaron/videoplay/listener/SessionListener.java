package com.aaron.videoplay.listener;

import com.aaron.videoplay.entity.User;
import com.aaron.videoplay.service.UserService;
import com.aaron.videoplay.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener {

    private UserService userService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        userService=WebApplicationContextUtils
                .getWebApplicationContext(sce.getServletContext())
                .getBean(UserServiceImpl.class);
        //这里不能使用Autowired注入 userService
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * session被创建时
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session is create");

    }

    /**
     * session被销毁时
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session deleted");
        HttpSession session=se.getSession();
        User user=(User)session.getAttribute("user");
        User temp=new User();
        temp.setUserId(user.getUserId());
        temp.setIsOn(0);
        userService.updateUser(temp);
        System.out.println("user "+user.getNickName()+" force logout");

    }
}
