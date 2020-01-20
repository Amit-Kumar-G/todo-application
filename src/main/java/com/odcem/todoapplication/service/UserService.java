package com.odcem.todoapplication.service;

import java.util.List;

import com.odcem.todoapplication.dtos.UserDto;
import com.odcem.todoapplication.json.UserJson;


public interface UserService {
	
	public UserJson getUser(Integer id);
	
	public List<UserJson> getAllUsers ();
	
	public List<UserJson> getAllUsersByName (String name);
	
	public UserJson addUser (UserJson userJson);
	
	public UserJson updateUser (UserJson userJson, Integer id);
	
	public UserJson deleteUser (Integer id);

	public UserJson getUserDetails(Integer id);
	
	public void retriveSoftDeletedUserById (Integer id);
}
