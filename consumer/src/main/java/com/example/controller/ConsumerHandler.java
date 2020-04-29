package com.example.controller;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

//该子工程与RESTTemplate的唯一区别是RESTTemplate没有在服务中心进行注册，所以不是消费者
//consumer是注册在注册中心的消费者

@RestController
@RequestMapping("/consumer")
public class ConsumerHandler {
    //通过RestTemplate调用Provider相关方法，所以要在启动类中建立RestTemplate
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
