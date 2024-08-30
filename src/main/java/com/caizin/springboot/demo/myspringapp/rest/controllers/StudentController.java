package com.caizin.springboot.demo.myspringapp.rest.controllers;

import com.caizin.springboot.demo.myspringapp.entities.Student;
import com.caizin.springboot.demo.myspringapp.rest.exceptions.NotFoundException;
import com.caizin.springboot.demo.myspringapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = service.findById(id);

        if(student == null) {
            throw new NotFoundException("Student not found for id: " + id);
        }

        return student;
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        return service.save(student);
    }
}
