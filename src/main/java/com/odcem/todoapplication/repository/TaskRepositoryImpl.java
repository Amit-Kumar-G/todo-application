package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.exception.TaskValidationException;
import com.odcem.todoapplication.exception.UserValidationException;
import com.odcem.todoapplication.json.TaskJson;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

	@Autowired
	private TaskJpaRepository<Task, Integer> taskJpaRepository;
	
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
			task = taskJpaRepository.findTaskById(id, false);
			if (task == null)
				throw new Exception();
		} catch (Exception e) {
			throw new TaskValidationException("The task with id " + id + " requested could not be found.");
		}
		return task;
	}

	@Override
	public List<Task> findAll() {
		
		return taskJpaRepository.findAll();
	}
	
	@Override
	public void deleteTask(Integer id) {
		
		taskJpaRepository.softDeleteTaskById(id);
	}

	@Override
	public void retriveSoftDeletedTaskById(Integer id) {
		taskJpaRepository.retriveSoftDeletedTaskById(id);
		
	}

}
