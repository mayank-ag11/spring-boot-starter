package com.caizin.springboot.demo.myspringapp.services;

import com.caizin.springboot.demo.myspringapp.dao.StudentRepository;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import com.caizin.springboot.demo.myspringapp.rest.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> student = repository.findById(id);

        if(student.isEmpty()) throw new NotFoundException("Student not found for id: " + id);

        return student.get();
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
