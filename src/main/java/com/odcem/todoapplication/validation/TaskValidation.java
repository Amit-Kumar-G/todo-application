package com.odcem.todoapplication.validation;

import com.odcem.todoapplication.exception.TaskValidationException;
import com.odcem.todoapplication.json.TaskJson;

public class TaskValidation {
	
	/**
	 * Checks if the fields in the taskJson are null.
	 * @see Id is a auto generated value, hence it is allowed to be null.
	 * @see <b> This validation is only for the Json Task. </b>
	 * @param 
	 */
	public static void validateAddTaskJson(TaskJson taskJson) {
		
		if (taskJson.getTitle() == null) {
			throw new TaskValidationException("Title cannot be empty.");
		}
		
		/**
		 * <b>A task MUST belong to a user.</b>
		 */
		if (taskJson.getUserId() == null) {
			throw new TaskValidationException("Task must belong to a user.");
		}
		
		/**
		 * @see Not null checking task category id
		 * <b>A task may not necessarily belong to a category.</b>
		 */
	}
	
	public static void checkIfTaskExists() {
		// TODO
	}
	

}
