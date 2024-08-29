package com.caizin.springboot.demo.myspringapp.controllers;

import com.caizin.springboot.demo.myspringapp.dao.StudentDAO;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentDAO.findAll();
    }
}
