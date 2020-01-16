package com.odcem.todoapplication.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odcem.todoapplication.model.Task;

@RestController
public class TaskController {

	/**
	 * Gets the task specified by the id path variable
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/tasks/{id}")
	public Task getTask (@PathVariable int id) {
		return new Task(id, "Test", "Test", Task.Status.PENDING, new Date(), new Date());
	}
	
	/**
	 * Gets all the tasks
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/tasks")
	public List<Task> getAllTasks () {
		return new ArrayList<Task>();
	}
	
	
	/**
	 * Adds a new task as per the request body.
	 * Request body is a map of String, String.
	 * @param body
	 *
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/tasks")
	public void addTask (@RequestBody Map<String, String> body) {
		new Task(Integer.parseInt(body.get("id")), "Test", "Test", Task.Status.PENDING, new Date(), new Date());
	}
	
	/**
	 * Updates a particular task.
	 * Cannot change some parameters such as the date the task was created.
	 * @param body
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
	public void updateTask (@RequestBody Map<String, String> body, @PathVariable int id) {
		// Logic to deny changing task date.
	}
}
