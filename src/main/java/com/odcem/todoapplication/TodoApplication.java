package com.odcem.todoapplication;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.odcem.todoapplication.model.Task;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(TodoApplication.class, args);
		
		//Task task = new Task();
		//task.setTitile();
		//System.out.println(new Tas);
	}

}
