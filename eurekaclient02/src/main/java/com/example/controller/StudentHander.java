package com.example.controller;

import com.example.entity.Student;
import com.example.repository.impl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHander {
    //从IOC容器中取出该实例化对象;
    //该注解对类的成员变量，方法进行标注完成自动装配的工作
    @Autowired
    private StudentRepositoryImpl studentRepository;
    //处理不同的请求方法
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        System.out.println("EurekaClient02 has been called and running at StudentHander findAll");
        return studentRepository.findAll();
    }


    //这里的id是指元素的下表而不是map中的key
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    //postman中，以post传送json数据时，id不仅是下标id，也是map中的key
    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        System.out.println("Running at StuHander save");
        studentRepository.save(student);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentRepository.deleteById(id);
    }

    //获取端口
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "当前端口为:"+port;
    }





}
