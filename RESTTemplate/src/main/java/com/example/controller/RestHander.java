package com.example.controller;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHander {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        //getForEntity方法返回ResponseEntity<T>,其是Spring对http请求响应的封装，其中包括几个重要元素：响应码，contentType,contentLength，响应消息体。
        //第一个参数表调用的服务地址，第二个参数表示返回值类型，最后一个参数用于替换前面的占位符{id}
        return restTemplate.getForEntity("http://localhost:8011/student/findAll", Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8011/student/findAll",Collection.class);
    }

    @PostMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8011/student/findById/{id}",Student.class,id);
    }



}

