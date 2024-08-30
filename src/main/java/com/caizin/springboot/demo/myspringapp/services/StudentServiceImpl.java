package com.caizin.springboot.demo.myspringapp.services;

import com.caizin.springboot.demo.myspringapp.dao.StudentDAO;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        studentDAO.delete(id);
    }
}
