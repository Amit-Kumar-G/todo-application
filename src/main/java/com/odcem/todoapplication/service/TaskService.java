package com.odcem.todoapplication.service;

import java.util.List;

import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.json.TaskJson;

public interface TaskService {
	
	public TaskJson getTask(Integer id);
	
	public List<TaskJson> getAllTasks ();
	
	public TaskJson addTask (TaskJson task);
	
	public TaskJson updateTask (TaskJson taskJson, int id);
	
	public TaskJson deleteTask(Integer id);
}
