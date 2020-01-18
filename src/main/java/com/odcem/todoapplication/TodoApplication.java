package com.odcem.todoapplication;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.odcem.todoapplication.entity.Task;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		
		// For log4j
		BasicConfigurator.configure();
		
		SpringApplication.run(TodoApplication.class, args);
	}
}
