package com.odcem.todoapplication.repository;

import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.Task;


public interface TaskRepository {

	public Task save(Task task);

	public Task getTaskById(Integer id);
	
}
