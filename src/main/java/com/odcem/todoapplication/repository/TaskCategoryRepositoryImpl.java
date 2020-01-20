package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.exception.TaskCategoryValidationException;
import com.odcem.todoapplication.exception.UserValidationException;

@Repository
public class TaskCategoryRepositoryImpl implements TaskCategoryRepository {

	@Autowired
	private TaskCategoryJpaRepository<TaskCategory, Integer> taskCategoryJpaRepository;

	@Override
	public TaskCategory addTaskCategory(TaskCategory taskCategory) {
		
		TaskCategory taskCategoryResponse;
		
		try {
			taskCategoryResponse = taskCategoryJpaRepository.save(taskCategory);
		} catch (Exception e) {
			throw new TaskCategoryValidationException("Could not save task. Task category already exists");
		}
		
		return taskCategoryResponse;
	}

	@Override
	public TaskCategory getTaskCategoryById(Integer id) {
		
		TaskCategory taskCategory;
		try {
			taskCategory = taskCategoryJpaRepository.findTaskCategoryById(id, false);
		} catch (Exception e) {
			throw new TaskCategoryValidationException("The task category with the given id does not exist.");
		}
		return taskCategory;
	}

	@Override
	public List<TaskCategory> getAllUsers() {
		return taskCategoryJpaRepository.findAll();
	}

	@Override
	public void deleteTaskCategory(Integer id) {
		taskCategoryJpaRepository.softDeleteTaskCategoryById(id);
	}

	@Override
	public void retriveSoftDeletedTaskCategoryById(Integer id) {
		taskCategoryJpaRepository.retriveSoftDeletedTaskCategoryById(id);
		
	}
}
