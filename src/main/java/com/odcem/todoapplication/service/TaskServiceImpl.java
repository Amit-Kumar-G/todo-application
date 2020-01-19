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
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.messages.Messages;
import com.odcem.todoapplication.repository.TaskRepository;
import com.odcem.todoapplication.utility.Utils;
import com.odcem.todoapplication.validation.TaskValidation;;

/**
 * 
 * @author amitkumargupta
 *
 */

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
	}
	
	@Override
	public List<TaskJson> getAllTasks () {
		
		List<TaskJson> taskJsons = new ArrayList<>();
		List<Task> tasks = taskRepository.findAll();
		for (Task t : tasks) {
			taskJsons.add(taskBuilder.buildTaskJsonFromTask(t));
		}
		return taskJsons;
	}
	
	@Override
	public TaskJson addTask (TaskJson taskJson) {
		
		TaskValidation.validateAddTaskJson(taskJson);
		taskJson.setDefaultValues();
		Task task = taskBuilder.buildNewTaskfromJson(taskJson);
		task = taskRepository.save(task);
		TaskJson taskJsonResponse = taskBuilder.buildTaskJsonFromTask(task);
		return taskJson;				
	}
	
	/**
	 * Parsing the request as a Json document.
	 * Only the updatable fields are changed.
	 * @see The save method automatically figures out if the record already exists and then updates the row.
	 * @param task
	 */
	@Override
	public TaskJson updateTask (TaskJson taskJson, int id) {
		Task task = taskRepository.getTaskById(id);
		task = taskBuilder.updateTaskFromJson(taskJson, task);
		task = taskRepository.save(task);
		return taskBuilder.buildTaskJsonFromTask(task);

	}
	
	@Override
	public TaskJson deleteTask(Integer id) {
		
		/*
		 * TODO: Soft deleting
		 */
		return null;
	}

}
