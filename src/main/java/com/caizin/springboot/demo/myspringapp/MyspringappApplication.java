package com.caizin.springboot.demo.myspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {"com.caizin.springboot.demo.myspringapp",
//							"com.caizin.springboot.demo.testscan"}
//)

@SpringBootApplication
public class MyspringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringappApplication.class, args);
	}

}
