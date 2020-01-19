package com.odcem.todoapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.builder.TaskBuilder;
import com.odcem.todoapplication.builder.UserBuilder;
import com.odcem.todoapplication.dtos.UserDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.json.UserJson;
import com.odcem.todoapplication.repository.UserRepository;
import com.odcem.todoapplication.validation.UserValidation;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserBuilder userBuilder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserJson getUser(Integer id) {
		
		User user =  userRepository.getUserById(id);
		// Fetching the tasks of the user.
		
		return userBuilder.buildJsonFromUser(user);
		

	}

	@Override
	public List<UserJson> getAllUsers() {
		
		List<User> users = userRepository.getAllUsers();
		List<UserJson> userJsons = new ArrayList<>();
		for (User u : users) {
			userJsons.add(userBuilder.buildJsonFromUser(u));
		}
		return userJsons;
	}

	@Override
	public UserJson addUser(UserJson userJson) {
		
		UserValidation.validateNewUserJson(userJson);		
		User user = userBuilder.buildNewUserFromJson(userJson);
		user = userRepository.saveNewUser(user);
		UserJson responseJson = userBuilder.buildJsonFromUser(user);
		return responseJson;
	}

	@Override
	public UserDto updateUser(UserJson userJson, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserJson getUserDetails(Integer id) {
		
		UserValidation.validateUserIdNull(id);
		User user = userRepository.getUserById(id);
		
		return null;
	}

	@Override
	public List<UserJson> getAllUsersByName(String name) {
		
		List<User> users = userRepository.getUsersByName(name);
		List<UserJson> userJsons = new ArrayList<>();
		for (User u : users) {
			userJsons.add(userBuilder.buildJsonFromUser(u));
		}
		return userJsons;
	}
	

}
