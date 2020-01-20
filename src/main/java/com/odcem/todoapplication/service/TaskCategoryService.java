package com.odcem.todoapplication.service;

import java.util.List;

import com.odcem.todoapplication.json.TaskCategoryJson;

public interface TaskCategoryService {

	TaskCategoryJson addTaskCategory(TaskCategoryJson taskCategoryJson);

	TaskCategoryJson getTaskById(Integer id);

	List<TaskCategoryJson> getAllTasks();

}
