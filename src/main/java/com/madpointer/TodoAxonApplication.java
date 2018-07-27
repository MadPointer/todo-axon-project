package com.madpointer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class TodoAxonApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(TodoAxonApplication.class, args);
    }
}
