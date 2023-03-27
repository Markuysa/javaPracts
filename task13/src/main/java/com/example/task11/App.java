package com.example.task11;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Value("${student.name}")
    private String studentName;

    @Value("${student.last_name}")
    private String studentLastName;

    @Value("${student.group}")
    private String studentGroup;

    @PostConstruct
    public void init() {
        Student student = new Student(studentName, studentLastName, studentGroup);
        System.out.println("Student: " + student.getName() + " " + student.getLastName() + ", Group: " + student.getGroup());
    }
}