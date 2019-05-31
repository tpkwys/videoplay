package com.example.demo.service;

import com.example.demo.service.impl.UserFeignClientFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//该接口的实现类由feign组件实现(通过HTTP远程调用) name 指定哪个提供者,fallback指定调用失败方案 ,fallback=UserFeignClientFallBack.class
@FeignClient(name="dm-user-provider")
public interface UserFeignClient {
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam("count") int count);
    //public Boolean login(@RequestBody User user);


}
