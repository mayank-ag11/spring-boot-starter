package com.caizin.springboot.demo.myspringapp;

import com.caizin.springboot.demo.myspringapp.dao.StudentDAO;
import com.caizin.springboot.demo.myspringapp.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleting student id: " + id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 4;
		System.out.println("Getting student with id: " + id);
		Student student = studentDAO.findById(id);

		System.out.println("Updating student...");
		student.setFirstName("Krish");
		student.setEmail("krish@gmail.com");

		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");

		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		int id = createStudent(studentDAO);
		System.out.println("Retrieving the student with id: " + id);
		Student student = studentDAO.findById(id);

		System.out.println("Found the student: " + student);
	}

	private int createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Mayank", "Agrawal", "mayank@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		int id = student.getId();
		System.out.println("Saved student. Generated id: " + id);
		return id;
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
