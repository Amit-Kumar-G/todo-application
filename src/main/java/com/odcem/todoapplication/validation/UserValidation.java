package com.odcem.todoapplication.validation;

import com.odcem.todoapplication.exception.UserValidationException;
import com.odcem.todoapplication.json.UserJson;

public class UserValidation {
	
	/**
	 * Used to validate a new user json sent from front end.
	 * Also validates if a user with the given email already exists.
	 * @see Not validating user id.
	 * @param userJson
	 */
	public static void validateNewUserJson(UserJson userJson) {
		
		if (userJson.getName() == null || userJson.getName().isEmpty()) {
			throw new UserValidationException("User name must be specified.");
		}
		
		if (userJson.getEmail() == null || userJson.getEmail().isEmpty()) {
			throw new UserValidationException("User Email address must be specified.");
		}				
	}
	
	public static void validateUserIdNull(Integer id) {
		
		if (id == null) {
			throw new UserValidationException("Invalid user ID / user ID not specified.");
		}			
	}
}
