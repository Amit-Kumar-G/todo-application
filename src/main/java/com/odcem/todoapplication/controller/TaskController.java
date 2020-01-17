package com.odcem.todoapplication.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odcem.todoapplication.enums.TaskStatusEnum;
import com.odcem.todoapplication.model.Task;
import com.odcem.todoapplication.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService; 
	
	/**
	 * Gets the task specified by the id path variable
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/tasks/{id}")
	public Task getTask (@PathVariable int id) {
		return taskService.getTask(id);
	}
	
	/**
	 * Gets all the tasks
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/tasks")
	public List<Task> getAllTasks () {
		return taskService.getAllTasks();
	}
	
	
	/**
	 * Adds a new task as per the request body.
	 * Request body is a map of String, String.
	 * @param body
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/tasks")
	public String addTask (@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
	/**
	 * Updates a particular task.
	 * Cannot change some parameters such as the date the task was created.
	 * @param body
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
	public String updateTask (@RequestBody String jsonRequest, @PathVariable int id) {
		return taskService.updateTask(jsonRequest, id);
	}
}
