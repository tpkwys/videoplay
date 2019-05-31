package com.example.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreFilter extends ZuulFilter {
   //注入config配置中心的config
    @Value("${token}")
    private boolean token;

    @Override
    public String filterType() {
        //代表该过滤器为前置过滤器 可选择 route error post
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        //同类型（pre内，route内），优先级问题，数值越小优先级越大
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //当前过滤器是否发挥作用 true 发挥 false 不
        return true;
    }

    @Override
    public Object run() {
        //过滤器核心业务逻辑
        RequestContext ctx=RequestContext.getCurrentContext();//请求信息的封装
        HttpServletRequest request=ctx.getRequest();
//        String key=request.getParameter("key");
//        ctx.set("thirdfilter",true);
//        if("1".equals(key)){
//            ctx.setSendZuulResponse(false);
//        }else{
//            ctx.set("thirdfilter",false);
//        }
        System.out.println("is need token:"+token);
        if(token){
            String token=request.getHeader("token");
            if(token==null||token.equals("")){
                //token无效
                //向后面处理链发送请求无效信息，没必要处理
                ctx.setSendZuulResponse(false);
                //给前端设置响应消息
                ctx.setResponseStatusCode(401);
                ctx.setResponseBody("{\"msg\":\"401,access without permission,pls login\"}");
                return "access defined";
            }
        }
        return "pass";//返回值暂时没用，预留值
    }
}
