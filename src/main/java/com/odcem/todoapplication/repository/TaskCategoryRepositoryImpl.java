package com.odcem.todoapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.exception.TaskCategoryValidationException;

@Repository
public class TaskCategoryRepositoryImpl implements TaskCategoryRepository {

	@Autowired
	private TaskCategoryJpaRepository taskCategoryJpaRepository;

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
			taskCategory = taskCategoryJpaRepository.getOne(id);
		} catch (Exception e) {
			throw new TaskCategoryValidationException("The task category with the given id does not exist.");
		}
		return taskCategory;
	}
}
