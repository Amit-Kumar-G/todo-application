package com.odcem.todoapplication.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.json.TaskCategoryJson;
import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.repository.UserRepository;

/**
 * 
 * @author amitkumargupta
 *
 */

@Service
public class TaskCategoryBuilderImpl implements TaskCategoryBuilder{

	@Autowired
	private TaskBuilder taskBuilder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public TaskCategory buildNewTaskCategoryFromJson(TaskCategoryJson taskCategoryJson) {
		
		TaskCategory taskCategory = new TaskCategory();
		taskCategory.setName(taskCategoryJson.getName());
		taskCategory.setUser(userRepository.getUserById(taskCategoryJson.getUserId()));
		taskCategory.setIsDeleted(false);
		return taskCategory;
	}

	@Override
	public TaskCategoryJson buildJsonFromTaskCategory(TaskCategory taskCategory) {
		
		TaskCategoryJson taskCategoryJson = new TaskCategoryJson();
		taskCategoryJson.setId(taskCategory.getId());
		taskCategoryJson.setName(taskCategory.getName());
		taskCategoryJson.setUserId(taskCategory.getUser().getId());
		List<Task> tasks = new ArrayList<>();
		if (taskCategory.getTasks() != null) {
			tasks.addAll(taskCategory.getTasks());
		}
		
		List<TaskJson> taskJsons = new  ArrayList<TaskJson>();
		for (Task t : tasks) {
			taskJsons.add(taskBuilder.buildTaskJsonFromTask(t));
		}
		
		taskCategoryJson.setTasks(taskJsons);
		return taskCategoryJson;
	}
}
