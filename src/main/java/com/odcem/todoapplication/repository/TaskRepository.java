package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.json.TaskJson;


public interface TaskRepository {

	public Task save(Task task);

	public Task getTaskById(Integer id);

	public List<Task> findAll();
	
}
