package com.example.controller;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonHandler {
    @Autowired
    private RestTemplate restTemplate;

    public Collection<Student> findAll(){
        //return restTemplate.getForEntity("http://localhost:8011/student/findAll",Collection.class).getBody();
        //直接在注册中心通过eurekaclient02中设置的spring: application: name: provider 来访问
        return restTemplate.getForEntity("http://provider/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/index")
    public String index(){
        return restTemplate.getForEntity("http://provider/student/index",String.class).getBody();
    }

}
