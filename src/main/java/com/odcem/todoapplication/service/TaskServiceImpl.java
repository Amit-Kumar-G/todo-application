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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.builder.TaskBuilder;
import com.odcem.todoapplication.builder.TaskBuilderImpl;
import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.messages.Messages;
import com.odcem.todoapplication.repository.TaskRepository;
import com.odcem.todoapplication.utility.Utils;
import com.odcem.todoapplication.validation.TaskValidation;;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskBuilder taskBuilder;
	
	private static final Logger logger = Logger.getLogger(TaskServiceImpl.class);
	
	@Override
	public TaskJson getTask(Integer id) {	
		
		// Validate id
		Task task =  taskRepository.getTaskById(id);
		return taskBuilder.buildTaskJsonFromTask(task);
//		return task;
	}
	
	@Override
	public List<TaskDto> getAllTasks () {
		return null;
//		logger.info("Trying to get all tasks");
//		List<Task> tasks = new ArrayList<Task>();
//		taskRepository.findAll().forEach(tasks::add);
//		return tasks;
	}
	
	@Override
	public TaskJson addTask (TaskJson taskJson) {
		
		TaskValidation.validateAddTaskJson(taskJson);
		taskJson.setDefaultValues();
		System.out.println("BEFORE JSON -> TASK " + taskJson.getId());
		Task task = taskBuilder.buildNewTaskfromJson(taskJson);
		System.out.println("AFTER JSON -> TASK " + taskJson.getId());
		task = taskRepository.save(task);
		System.out.println("AFTER SAVING TASK " + taskJson.getId());
		TaskJson taskJsonResponse = taskBuilder.buildTaskJsonFromTask(task);
		System.out.println("AFTER TASK -> JSON " + taskJson.getId());
		return taskJson;				
	}
	
	/**
	 * @see The save method automatically figures out if the record already exists and then updates the row.
	 * @param task
	 */
	@Override
	public TaskDto updateTask (TaskDto taskDto, int id) {
		
		return null;
		 /*
		  * Cannot change the following fields while updating a task.
		  * id: Unique and auto incremented, so cannot change
		  * creation_date.
		  */
		
		/*
		 * Parsing the request as a Json document.
		 * Only the updatable fields are changed.
		 */
		
//		logger.info("Attempting to update task with id " + id);
//		JSONObject jsonObject = new JSONObject(jsonRequest);
//		Task task = taskRepository.findById(id).orElse(null);
//		
//		if (task == null) {
//			logger.error("The specified task was not found in the database.");
//			return Messages.TASK_NOT_FOUND;
//		}
//		
//		if (!jsonObject.isNull("title")) {
//			
//			task.setTitle(jsonObject.getString("title"));
//		}
//		
//		if (!jsonObject.isNull("description")) {
//			
//			task.setDescription(jsonObject.getString("description"));
//		}
//		
//		if (!jsonObject.isNull("status")) {
//			
//			task.setStatus((byte) 0);
//		}
//		
//		if (!jsonObject.isNull("deadline_date")) {
//			
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
//			try {
//				task.setDeadlineDate(formatter.parse(jsonObject.getString("deadline_date")));
//			} catch (JSONException | ParseException e) {
//				logger.error("There was an error pasrsing the date from json data. Did not update task.");
//				return "Error parsing JSON.";
//			}
//		}
//		
//		
//		taskRepository.save(task);
//		logger.info("Task updated successfully");
//		return Messages.SUCCESS;
	}
	
	@Override
	public TaskDto deleteTask(int id) {
		
		return null;
	}

}
