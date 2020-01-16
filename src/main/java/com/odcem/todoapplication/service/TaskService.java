package com.odcem.todoapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void addTask (Task task) {
		taskRepository.save(task);
	}
	
	/**
	 * @see The save method automatically figures out if the record already exists and then updates the row.
	 * @param task
	 */
	public void updateTask (Task task) {
		
		
		 /*
		  * TODO: Add logic to check what fields are changed. 
		  */
		taskRepository.save(task);
	}
}
