package com.caizin.springboot.demo.myspringapp.dao;

import com.caizin.springboot.demo.myspringapp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
