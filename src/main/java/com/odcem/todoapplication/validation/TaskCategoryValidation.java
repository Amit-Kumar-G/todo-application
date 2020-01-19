package com.odcem.todoapplication.validation;

import com.odcem.todoapplication.exception.UserValidationException;
import com.odcem.todoapplication.json.TaskCategoryJson;

public class TaskCategoryValidation {
	
	public static void validateNewTaskCategoryJson(TaskCategoryJson taskCategoryJson) {
		if (taskCategoryJson.getName() == null || taskCategoryJson.getName().isEmpty()) {
			throw new UserValidationException("Category name must be specified.");
		}
		validateUserIdNull(taskCategoryJson.getUserId());
	}
	
	public static void validateUserIdNull(Integer id) {
		
		System.out.println(id);
		if (id == null) {
			throw new UserValidationException("Invalid user ID / user ID not specified.");
		}			
	}
}
