package com.odcem.todoapplication.builder;

import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.json.TaskJson;

public interface TaskBuilder {
	
	public Task buildNewTaskfromJson(TaskJson taskJson);

	public TaskDto buildTaskDtoFromTask(Task task);

	public TaskJson buildTaskJsonFromTask(Task task);
}
