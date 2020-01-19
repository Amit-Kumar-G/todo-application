package com.odcem.todoapplication;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		
		// For log4j
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		
		SpringApplication.run(TodoApplication.class, args);
	}
}
