package com.odcem.todoapplication.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.enums.TaskStatusEnum;
import com.odcem.todoapplication.messages.Messages;
import com.odcem.todoapplication.model.Task;
import com.odcem.todoapplication.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public Task getTask(int id) {		
		return taskRepository.findById(id).orElse(null);
	}
	
	public List<Task> getAllTasks () {
		List<Task> tasks = new ArrayList<Task>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	public String addTask (Task task) {
		
		try {
			task.setCreationDate(new Date());
			
			// Sets the default task status to pending if not specified.
			if (task.getStatus() == null) {
				task.setStatus(TaskStatusEnum.PENDING);
			}
			
			taskRepository.save(task);
			return "Success.";
		}
		catch (Exception e) {
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
		
		JSONObject jsonObject = new JSONObject(jsonRequest);
		Task task = taskRepository.findById(id).orElse(null);
		
		if (task == null) {
			
			return Messages.TASK_NOT_FOUND;
		}
		
		if (!jsonObject.isNull("title")) {
			
			task.setTitle(jsonObject.getString("title"));
		}
		
		if (!jsonObject.isNull("description")) {
			
			task.setDescription(jsonObject.getString("description"));
		}
		
		if (!jsonObject.isNull("status")) {
			
			task.setStatus(TaskStatusEnum.valueOf(jsonObject.getString("status")));
		}
		
		if (!jsonObject.isNull("deadline_date")) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			try {
				task.setDeadlineDate(formatter.parse(jsonObject.getString("deadline_date")));
			} catch (JSONException | ParseException e) {
				
				return "Error parsing JSON.";
			}
		}
		
		
		taskRepository.save(task);
		return Messages.SUCCESS;
	}
}
