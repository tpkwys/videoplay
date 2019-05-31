import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 配置过滤器
 */

@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegister(){
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(new MyFilter());//添加过滤器

        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径

        registration.addInitParameter("name", "alue");//添加默认参数

        registration.setName("MyFilter");//设置优先级

        registration.setOrder(1);//设置优先级

        return registration;
    }
    public class MyFilter implements Filter{
        @Override
        public void init(FilterConfig filterConfig) {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException{
            HttpServletRequest  request=(HttpServletRequest) servletRequest;
            System.out.println("MyFilter:url="+request.getRequestURL());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

}
