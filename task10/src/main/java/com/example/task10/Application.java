package com.example.task10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(com.example.tasks.tenthTask.BeanConfig.class);

        com.example.tasks.tenthTask.Programmer programmer = context.getBean(com.example.tasks.tenthTask.Junior.class);
        programmer.doCoding();

        programmer = context.getBean(com.example.tasks.tenthTask.Middle.class);
        programmer.doCoding();

        programmer = context.getBean(com.example.tasks.tenthTask.Senior.class);
        programmer.doCoding();
    }

}
