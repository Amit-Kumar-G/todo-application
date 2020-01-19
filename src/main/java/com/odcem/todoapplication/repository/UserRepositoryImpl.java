package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.User;
import com.odcem.todoapplication.exception.UserValidationException;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private UserJpaRepository userJpaRepository;

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
			responseUser = userJpaRepository.getOne(id);			
		} catch (Exception e) {			
			throw new UserValidationException("Error fetching user. User does not exist.");
		}		
		
		return responseUser;
	}

	@Override
	public List<User> getAllUsers() {		
		List<User> users = userJpaRepository.findAll();
		return users;
	}
}
