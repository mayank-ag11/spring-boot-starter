package com.caizin.springboot.demo.myspringapp.controllers;

import com.caizin.springboot.demo.myspringapp.dao.StudentDAO;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import com.caizin.springboot.demo.myspringapp.error.ErrorResponse;
import com.caizin.springboot.demo.myspringapp.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exc) {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc) {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
