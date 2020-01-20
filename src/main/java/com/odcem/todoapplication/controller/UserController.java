package com.odcem.todoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.odcem.todoapplication.json.UserJson;
import com.odcem.todoapplication.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/users")
	public ResponseEntity<UserJson> addUser (@RequestBody UserJson userJson) {
		UserJson responseJson = userService.addUser(userJson);
		return new ResponseEntity<UserJson>(responseJson, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserJson> getUser (@PathVariable Integer id) {
		UserJson responseJson = userService.getUser(id);
		return new ResponseEntity<UserJson>(responseJson, HttpStatus.OK);
	}
	
	/*
	 * TODO
	@GetMapping(value = "/users/{id}/details")
	public ResponseEntity<UserJson> getUserDetails (@PathVariable Integer id) {
		UserJson responseJson = userService.getUserDetails(id);
		return new ResponseEntity<UserJson>(responseJson, HttpStatus.OK);
	}
	*/
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserJson>> getAllUser () {		
		List<UserJson> users = userService.getAllUsers();
		return new ResponseEntity<List<UserJson>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/find/{name}")
	public ResponseEntity<List<UserJson>> getAllUsersByName (@PathVariable String name) {		
		List<UserJson> users = userService.getAllUsersByName(name);
		return new ResponseEntity<List<UserJson>>(users, HttpStatus.OK);
	}
	
	@PutMapping(value = "/users/{id}")
	public ResponseEntity<UserJson> updateUser(@RequestBody UserJson userJson, @PathVariable Integer id) {
		
		userJson = userService.updateUser(userJson, id);
		return new ResponseEntity<UserJson>(userJson, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "users/{id}")
	public ResponseEntity<DeletedSuccessfullyJson> deleteUser(@PathVariable Integer id) {
		
		userService.deleteUser(id);

		// Sending back empty object.
		DeletedSuccessfullyJson deletedSuccessfullyJson = new DeletedSuccessfullyJson("Deleted successfully");
		return new ResponseEntity<DeletedSuccessfullyJson>(deletedSuccessfullyJson, HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}/recover")
	public ResponseEntity<DeletedSuccessfullyJson> retriveSoftDeletedUser(@PathVariable Integer id) {
		
		userService.retriveSoftDeletedUserById(id);

		// Sending back empty object.
		DeletedSuccessfullyJson deletedSuccessfullyJson = new DeletedSuccessfullyJson("Recovered succcessfully.");
		return new ResponseEntity<DeletedSuccessfullyJson>(deletedSuccessfullyJson, HttpStatus.OK);
	}
}
