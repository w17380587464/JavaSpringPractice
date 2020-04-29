package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


//包含EnableZuulServer,标记该类为网关启动类
//将Spring Boot应用所有符合条件的@Configuration加载到当前创建的IOC中
@EnableZuulProxy
@EnableAutoConfiguration
public class ZuulApplication {
    public static void main(String[]args){
        SpringApplication.run(ZuulApplication.class,args);
    }


}
