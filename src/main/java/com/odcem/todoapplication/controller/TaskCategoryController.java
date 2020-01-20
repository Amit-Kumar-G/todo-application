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

import com.odcem.todoapplication.json.TaskCategoryJson;
import com.odcem.todoapplication.service.TaskCategoryService;

/**
 * 
 * @author amitkumargupta
 *
 */

@RestController
public class TaskCategoryController {
	
	@Autowired
	private TaskCategoryService taskCategoryService;
	
	@PostMapping(value = "/taskCategory")
	public ResponseEntity<TaskCategoryJson> addTaskCategory (@RequestBody TaskCategoryJson taskCategoryJson) {
		TaskCategoryJson responseJson = taskCategoryService.addTaskCategory(taskCategoryJson);
		return new ResponseEntity<TaskCategoryJson>(responseJson, HttpStatus.OK);
	}
	
	@GetMapping(value = "/taskCategory/{id}")
	public ResponseEntity<TaskCategoryJson> getTaskCategory (@PathVariable Integer id) {
		TaskCategoryJson responseJson = taskCategoryService.getTaskById(id);
		return new ResponseEntity<TaskCategoryJson>(responseJson, HttpStatus.OK);
	}
	
	@GetMapping(value = "/taskCategory")
	public ResponseEntity<List<TaskCategoryJson>> getAllTasks () {
		List<TaskCategoryJson> responseJson = taskCategoryService.getAllTasks();
		return new ResponseEntity<List<TaskCategoryJson>>(responseJson, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/taskCategory/{id}")
	public ResponseEntity<DeletedSuccessfullyJson> deleteUser(@PathVariable Integer id) {
		
		taskCategoryService.deleteUser(id);

		// Sending back empty object.
		DeletedSuccessfullyJson deletedSuccessfullyJson = new DeletedSuccessfullyJson("Deleted successfully");
		return new ResponseEntity<DeletedSuccessfullyJson>(deletedSuccessfullyJson, HttpStatus.OK);
	}
	
	@PutMapping("/taskCategory/{id}/recover")
	public ResponseEntity<DeletedSuccessfullyJson> retriveSoftDeletedUser(@PathVariable Integer id) {
		
		taskCategoryService.retriveSoftDeletedUserById(id);

		// Sending back empty object.
		DeletedSuccessfullyJson deletedSuccessfullyJson = new DeletedSuccessfullyJson("Recovered succcessfully.");
		return new ResponseEntity<DeletedSuccessfullyJson>(deletedSuccessfullyJson, HttpStatus.OK);
	}
}
