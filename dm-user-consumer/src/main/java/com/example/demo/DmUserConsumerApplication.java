package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //注册到Eureka server
@EnableFeignClients  //接口调用
public class DmUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmUserConsumerApplication.class, args);
    }

}
