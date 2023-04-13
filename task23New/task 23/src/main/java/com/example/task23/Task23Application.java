package com.example.task23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication
@EnableJdbcHttpSession
public class Task23Application {

    public static void main(String[] args) {
        SpringApplication.run(Task23Application.class, args);
    }

}
