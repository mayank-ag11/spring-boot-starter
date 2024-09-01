package com.caizin.springboot.demo.myspringapp.dao;

import com.caizin.springboot.demo.myspringapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members") // change the default API path
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
