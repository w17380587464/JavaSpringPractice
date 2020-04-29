package com.example.repository.impl;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Repository注解将接口的一个实现类交给Spring处理
@Repository
public class StudentRepositoryImpl implements StudentRepository {
    public static Map<Long,Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put(1L,new Student(1L, "Bob",21));
        studentMap.put(2L,new Student(3L, "Lisi",22));
    }

    @Override
    public Collection<Student> findAll() {
        System.out.println("----------------------------------------------");
        System.out.println(studentMap.get(1L).toString());
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void save(Student student) {
        System.out.println("Running at StuImpl save");
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
