package com.odcem.todoapplication.builder;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.MarkerManager.Log4jMarker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.dtos.UserDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.json.TaskCategoryJson;
import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.json.UserJson;
import com.odcem.todoapplication.validation.UserValidation;

/**
 * 
 * @author amitkumargupta
 *
 */

@Service
public class UserBuilderImpl implements UserBuilder {

	@Autowired
	private TaskBuilder taskBuilder;
	
	@Autowired
	private TaskCategoryBuilder taskCategoryBuilder;
	
	@Override
	public User buildNewUserFromJson(UserJson userJson) {
		
		User user = new User(userJson.getName(), userJson.getEmail());
		user.setIsDeleted(false);
		return user;
	}

	@Override
	public UserDto buildUserDtoFromUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Not null checking for non null entity fields
	 */
	@Override
	public UserJson buildJsonFromUser(User user) {
		
		UserJson userJson = new UserJson();
		userJson.setId(user.getId());
		userJson.setEmail(user.getEmail());
		userJson.setName(user.getName());

		// Populating tasks
		List<Task> tasks = new ArrayList<>();
		if (user.getTasks() != null) {
			tasks.addAll(user.getTasks());
		}
		List<TaskJson> taskJsons = new ArrayList<TaskJson>();
		for (Task t : tasks) {
			taskJsons.add(taskBuilder.buildTaskJsonFromTask(t));
		}
		userJson.setTaskJsonList(taskJsons);
		
		
		// Populating task category names
		List<TaskCategory> taskCategories = new ArrayList<>();
		if (user.getTaskCategories() != null) {
			taskCategories.addAll(user.getTaskCategories());
		}
		List<String> taskCategoryNames = new ArrayList<>();
		for (TaskCategory tc : taskCategories) {
			taskCategoryNames.add(tc.getName());
		}
		userJson.setTaskCategoryNames(taskCategoryNames);
		
		return userJson;
	}

	@Override
	public User updateExistingUserFromJson(User user, UserJson userJson) {
		
		if (userJson.getName() != null) {
			user.setName(userJson.getName());
		}
		
		if (userJson.getEmail() != null) {
			user.setEmail(userJson.getEmail());
		}
		return user;
	}

}
