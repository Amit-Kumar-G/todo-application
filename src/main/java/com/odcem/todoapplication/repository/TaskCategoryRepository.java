package com.odcem.todoapplication.repository;

import com.odcem.todoapplication.entity.TaskCategory;

public interface TaskCategoryRepository {

	TaskCategory addTaskCategory(final TaskCategory taskCategory);

	TaskCategory getTaskCategoryById(final Integer id);

}
