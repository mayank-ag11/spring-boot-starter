package com.caizin.springboot.demo.myspringapp.dao;

import com.caizin.springboot.demo.myspringapp.entities.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();
}
