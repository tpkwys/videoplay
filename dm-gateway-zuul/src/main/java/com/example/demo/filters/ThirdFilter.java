package com.example.demo.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//@Component
public class ThirdFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=RequestContext.getCurrentContext();//请求信息的封装
        return ctx.sendZuulResponse()&&ctx.getBoolean("thirdfilter");//根据前一个过滤器响应码 选择是否执行该过滤器
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();//请求信息的封装
        HttpServletRequest request=ctx.getRequest();
        String key=request.getParameter("key");
        if("3".equals(key)){
            ctx.setSendZuulResponse(false);
        }
        return null;
    }
}
