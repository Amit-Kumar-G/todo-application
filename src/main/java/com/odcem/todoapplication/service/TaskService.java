package com.odcem.todoapplication.service;

import java.util.List;

import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.json.TaskJson;

public interface TaskService {
	
	public TaskJson getTask(Integer id);
	
	public List<TaskDto> getAllTasks ();
	
	public TaskJson addTask (TaskJson task);
	
	public TaskDto updateTask (TaskDto taskDto, int id);
	
	public TaskDto deleteTask(int id);
}
