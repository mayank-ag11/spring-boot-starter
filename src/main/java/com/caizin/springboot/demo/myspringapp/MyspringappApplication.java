package com.caizin.springboot.demo.myspringapp;

import com.caizin.springboot.demo.myspringapp.dao.StudentDAO;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(
//		scanBasePackages = {"com.caizin.springboot.demo.myspringapp",
//							"com.caizin.springboot.demo.testscan"}
//)

@SpringBootApplication
public class MyspringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Mayank", "Agrawal", "mayank@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
		Student student2 = new Student("Jane", "Doe", "janedoe@gmail.com");
		Student student3 = new Student("Mary", "Public", "mary@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}
}
