package com.caizin.springboot.demo.myspringapp.rest.controllers;

import com.caizin.springboot.demo.myspringapp.dao.StudentDAO;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import com.caizin.springboot.demo.myspringapp.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = studentDAO.findById(id);

        if(student == null) {
            throw new NotFoundException("Student not found for id: " + id);
        }

        return student;
    }
}
