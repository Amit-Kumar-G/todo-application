package com.odcem.todoapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.exception.TaskValidationException;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

	@Autowired
	TaskJpaRepository taskJpaRepository;
	
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

}
