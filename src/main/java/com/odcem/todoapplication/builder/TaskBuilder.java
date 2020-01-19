package com.odcem.todoapplication.builder;

import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.json.TaskJson;

/**
 * 
 * @author amitkumargupta
 *
 */

public interface TaskBuilder {
	
	public Task buildNewTaskfromJson(final TaskJson taskJson);

	public TaskDto buildTaskDtoFromTask(final Task task);

	public TaskJson buildTaskJsonFromTask(final Task task);

	public Task updateTaskFromJson(final TaskJson taskJson, final Task task);
}
