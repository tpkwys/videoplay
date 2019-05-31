package com.aaron.videoplay.filter;

import com.aaron.videoplay.entity.JsonResult;
import com.aaron.videoplay.entity.ResultCode;
import com.aaron.videoplay.entity.User;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//urlPatterns要过滤的请求路径
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/video/security/*","/user/logout"})
public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;

        HttpSession session=request.getSession(false);
        User user=null;
        if(session!=null&&(user=(User) session.getAttribute("user"))!=null){
            filterChain.doFilter(servletRequest,servletResponse);//请求转发
        }else{
            servletResponse.setCharacterEncoding("UTF-8");
            JsonResult result=new JsonResult(ResultCode.NOT_LOGIN,ResultCode.NOT_LOGIN.msg());
            String jsonStr=JSON.toJSONString(result);
            servletResponse.getWriter().write(jsonStr);
            return;
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");

    }
}
