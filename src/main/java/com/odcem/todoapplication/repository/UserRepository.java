package com.odcem.todoapplication.repository;

import java.util.List;

import com.odcem.todoapplication.entity.User;

public interface UserRepository {
	
	public User saveNewUser (User user);
	
	public User getUserById (Integer id);
	
	public List<User> getAllUsers();
}
