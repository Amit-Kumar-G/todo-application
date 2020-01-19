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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.service.TaskService;
import com.odcem.todoapplication.service.TaskServiceImpl;

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
//	@GetMapping
//	@RequestMapping(value = "/tasks")
//	public List<Task> getAllTasks () {
//		return taskService.getAllTasks();
//	}
	
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
//	@PutMapping(value = "/tasks/{id}")
//	public String updateTask (@RequestBody String jsonRequest, @PathVariable int id) {
//		return taskService.updateTask(jsonRequest, id);
//	}
//	
//	@DeleteMapping(value = "/tasks/{id}")
//	public String deleteTask (@PathVariable int id) {
//		return taskService.deleteTask(id);
//	}
}
