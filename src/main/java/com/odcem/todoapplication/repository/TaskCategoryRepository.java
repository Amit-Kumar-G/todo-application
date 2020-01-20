package com.odcem.todoapplication.repository;

import java.util.List;

import com.odcem.todoapplication.entity.TaskCategory;

public interface TaskCategoryRepository {

	TaskCategory addTaskCategory(final TaskCategory taskCategory);

	TaskCategory getTaskCategoryById(final Integer id);

	List<TaskCategory> getAllUsers();

	void deleteTaskCategory(Integer id);

	void retriveSoftDeletedTaskCategoryById(Integer id);

}
