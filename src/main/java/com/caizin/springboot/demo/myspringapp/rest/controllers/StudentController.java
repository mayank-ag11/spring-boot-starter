package com.caizin.springboot.demo.myspringapp.rest.controllers;

import com.caizin.springboot.demo.myspringapp.entities.Student;
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
        return service.findById(id);
    }

    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        return service.save(student);
    }

    @PutMapping()
    public Student updateStudent(@RequestBody Student student) {
        return service.update(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.delete(id);
        return "Deleted student id: " + id;
    }
}
