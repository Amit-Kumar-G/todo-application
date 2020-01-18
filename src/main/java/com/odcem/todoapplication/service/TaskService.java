package com.odcem.todoapplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.messages.Messages;
import com.odcem.todoapplication.repository.TaskRepository;;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	private static final Logger logger = Logger.getLogger(TaskService.class);
	
	public Task getTask(int id) {	
		
		logger.info(String.format("Trying to get task {}", id));
		Task task = null;
		try {
			task = taskRepository.findById(id).orElse(null);
			
			if (task == null) {
				logger.error("Could not find task with id " + id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		
		logger.info("Found task with id " + id);
		return task;
	}
	
	public List<Task> getAllTasks () {
		logger.info("Trying to get all tasks");
		List<Task> tasks = new ArrayList<Task>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	public String addTask (Task task) {
		
		logger.info("Trying to add a new task.");
		
		try {
			task.setCreationDate(new Date());
		
			// Sets the default task status to pending if not specified.
			if (task.getStatus() == null) {
				logger.warn("Task satus was empty, adding default value.");
				task.setStatus((byte) 0);
			}
			
			taskRepository.save(task);
			logger.info("Added task successfully");
			return "Success.";
		}
		
		catch (Exception e) {
			logger.error("Task not null field cannot be ommited. Did not add task.");
			return "Field cannot be null.";
		}
		
	}
	
	/**
	 * @see The save method automatically figures out if the record already exists and then updates the row.
	 * @param task
	 */
	public String updateTask (String jsonRequest, int id) {
		
		
		 /*
		  * Cannot change the following fields while updating a task.
		  * id: Unique and auto incremented, so cannot change
		  * creation_date.
		  */
		
		/*
		 * Parsing the request as a Json document.
		 * Only the updatable fields are changed.
		 */
		
		logger.info("Attempting to update task with id " + id);
		JSONObject jsonObject = new JSONObject(jsonRequest);
		Task task = taskRepository.findById(id).orElse(null);
		
		if (task == null) {
			logger.error("The specified task was not found in the database.");
			return Messages.TASK_NOT_FOUND;
		}
		
		if (!jsonObject.isNull("title")) {
			
			task.setTitle(jsonObject.getString("title"));
		}
		
		if (!jsonObject.isNull("description")) {
			
			task.setDescription(jsonObject.getString("description"));
		}
		
		if (!jsonObject.isNull("status")) {
			
			task.setStatus((byte) 0);
		}
		
		if (!jsonObject.isNull("deadline_date")) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			try {
				task.setDeadlineDate(formatter.parse(jsonObject.getString("deadline_date")));
			} catch (JSONException | ParseException e) {
				logger.error("There was an error pasrsing the date from json data. Did not update task.");
				return "Error parsing JSON.";
			}
		}
		
		
		taskRepository.save(task);
		logger.info("Task updated successfully");
		return Messages.SUCCESS;
	}
}
