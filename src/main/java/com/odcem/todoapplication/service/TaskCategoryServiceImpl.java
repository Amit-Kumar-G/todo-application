package com.odcem.todoapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.builder.TaskCategoryBuilder;
import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.json.TaskCategoryJson;
import com.odcem.todoapplication.json.UserJson;
import com.odcem.todoapplication.repository.TaskCategoryRepository;
import com.odcem.todoapplication.validation.TaskCategoryValidation;

/**
 * 
 * @author amitkumargupta
 *
 */

@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {

	@Autowired
	private TaskCategoryRepository taskCategoryRepository;
	
	@Autowired
	private TaskCategoryBuilder taskCategoryBuilder;
	
	@Override
	public TaskCategoryJson addTaskCategory(TaskCategoryJson taskCategoryJson) {
		TaskCategoryValidation.validateNewTaskCategoryJson(taskCategoryJson);	
		TaskCategory taskCategory = taskCategoryBuilder.buildNewTaskCategoryFromJson(taskCategoryJson);
		taskCategory = taskCategoryRepository.addTaskCategory(taskCategory);
		TaskCategoryJson responseCategoryJson = taskCategoryBuilder.buildJsonFromTaskCategory(taskCategory);
		return responseCategoryJson;	
	}

	@Override
	public TaskCategoryJson getTaskById(Integer id) {
		
		TaskCategory taskCategory = taskCategoryRepository.getTaskCategoryById(id);
		return taskCategoryBuilder.buildJsonFromTaskCategory(taskCategory);
	}

	@Override
	public List<TaskCategoryJson> getAllTasks() {
		
		List<TaskCategory> taskCategories = taskCategoryRepository.getAllUsers();
		List<TaskCategoryJson> taskCategoryJsons = new ArrayList<>();
		for (TaskCategory tc : taskCategories) {
			taskCategoryJsons.add(taskCategoryBuilder.buildJsonFromTaskCategory(tc));
		}
		return taskCategoryJsons;
	}

}
