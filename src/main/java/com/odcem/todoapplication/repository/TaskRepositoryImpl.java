package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.exception.TaskValidationException;
import com.odcem.todoapplication.json.TaskJson;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

	@Autowired
	private TaskJpaRepository taskJpaRepository;
	
	@Override
	public Task save(Task task) {
		
		Task responseTask;
		
		try {
			responseTask = taskJpaRepository.save(task);
		} catch (Exception e) {
			throw new TaskValidationException("The task with id " + task.getId() + " already exists.");
		}
		return responseTask;
	}

	@Override
	public Task getTaskById(Integer id) {
		
		Task task;
		
		try {
			task = taskJpaRepository.getOne(id);
		} catch (Exception e) {
			throw new TaskValidationException("The task with id " + id + " requested could not be found.");
		}
		return task;
	}

	@Override
	public List<Task> findAll() {
		
		return taskJpaRepository.findAll();
	}

}
