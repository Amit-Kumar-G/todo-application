package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.exception.UserValidationException;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserJpaRepository<User, Integer> userJpaRepository;
	
	@Autowired
	private TaskJpaRepository taskJpaRepository;
	
	@Override
	public User saveNewUser(User user) {
				
		User responseUser;		
		try {			
			responseUser = userJpaRepository.save(user);			
		} catch (Exception e) {			
			throw new UserValidationException("Error adding new user. The user already exists.");
		}		
		
		return responseUser;
	}

	@Override
	public User getUserById(Integer id) {
		
		User responseUser;		
		try {			
			responseUser = userJpaRepository.findUserById(id, false);	
			if (responseUser == null)
				throw new Exception();
			
		} catch (Exception e) {			
			throw new UserValidationException("Error fetching user. User does not exist.");
		}		
		
		return responseUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {		
		List<User> users = userJpaRepository.findAll();
		return users;
	}

	@Override
	public List<User> getUsersByName(String name) {
		List<User> users = userJpaRepository.findUserByName(name);
		return users;
	}

	@Override
	public User updateUser(User user) {
		
		user = userJpaRepository.save(user);
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		
		User user = getUserById(id);
		Integer taskCount = userJpaRepository.getNumberOfUserTasks(user);
		Integer taskCategoryCount = userJpaRepository.getNumberOfUserTasks(user);
		if (taskCount != 0 || taskCategoryCount != 0) {
			throw new UserValidationException("Cannot delete user who has tasks or task categories assigned to him.");
		}
		userJpaRepository.softDeleteUserById(id);
	}

	@Override
	public void retriveSoftDeletedUserById(Integer id) {
		userJpaRepository.retriveSoftDeletedUserById(id);
		
	}
}
