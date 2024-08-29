package com.caizin.springboot.demo.myspringapp.services;

import com.caizin.springboot.demo.myspringapp.entities.Student;

import java.util.List;

public interface StudentService {
    Student findById(Integer id);

    List<Student> findAll();
}
