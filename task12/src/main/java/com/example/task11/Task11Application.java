package com.example.task11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task11Application {

	// http://localhost:8080/actuator/health - actuator
	public static void main(String[] args) {
		SpringApplication.run(Task11Application.class, args);
	}
	@Bean
	public App app(@Value("${inputFile}") String inputFile, @Value("${outputFile}") String outputFile) {
		return new App(inputFile, outputFile);
	}
}

