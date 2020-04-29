package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RESTTemplateApplication {

    public static void main(String []args){
        SpringApplication.run(RESTTemplateApplication.class,args);
    }

    //产生一个Bean对象，该对象交给Spring管理，该方法只会调用一次，，随后Spring会将
    //该对象放到自己的IOC容器中。
    @Bean
    public RestTemplate restTemplate(){
        //在启动的时候会直接创建RestTemplate实例
        return new RestTemplate();
    }
}
