package com.example.task11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task11Application {

	// http://localhost:8080/actuator/health - actuator
	public static void main(String[] args) {
		SpringApplication.run(Task11Application.class, args);
	}

}
