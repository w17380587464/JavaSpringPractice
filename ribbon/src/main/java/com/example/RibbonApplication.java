package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//Ribbon不提供任何服务
@SpringBootApplication
public class RibbonApplication {
    public static void main(String[]args){
        SpringApplication.run(RibbonApplication.class,args);
    }

// 负载均衡注解
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
