package com.odcem.todoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService; 
	
	@GetMapping(value = "/tasks/{id}")
	public TaskJson getTask (@PathVariable int id) {
		return taskService.getTask(id);
	}
	
	/**
	 * @return List of tasks
	 */
	@GetMapping(value = "/tasks")
	public List<TaskJson> getAllTasks () {
		return taskService.getAllTasks();
	}
	
	/**
	 * @param body
	 */
	@PostMapping(value = "/tasks")
	public ResponseEntity<TaskJson> addTask (@RequestBody TaskJson taskJson) {	
		TaskJson taskJsonResponse = taskService.addTask(taskJson);
		return new ResponseEntity<TaskJson>(taskJsonResponse, HttpStatus.OK);
	}
	
	/**
	 * Updates a particular task.
	 * Cannot change some parameters such as the date the task was created.
	 * @param body
	 * @param id
	 */
	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<TaskJson> updateTask (@RequestBody TaskJson taskJson, @PathVariable int id) {
		TaskJson taskJsonResponse = taskService.updateTask(taskJson, id);
		return  new ResponseEntity<TaskJson>(taskJsonResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/tasks/{id}")
	public TaskJson deleteTask (@PathVariable Integer id) {
		return taskService.deleteTask(id);
	}
}
