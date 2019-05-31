package com.example.demo.service.impl;

import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallBack implements com.example.demo.service.UserFeignClient {
    @Override
    public String login(int count) {
        return "异常";
    }
}
