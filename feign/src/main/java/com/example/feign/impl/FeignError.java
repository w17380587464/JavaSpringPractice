package com.example.feign.impl;

import com.example.entity.Student;
import com.example.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

//通过该注解将FeignError实例注入IOC容器中
@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中...........";
    }
}
