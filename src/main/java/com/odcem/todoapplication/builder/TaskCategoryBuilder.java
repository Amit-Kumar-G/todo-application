package com.odcem.todoapplication.builder;

import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.json.TaskCategoryJson;

/**
 * 
 * @author amitkumargupta
 *
 */

public interface TaskCategoryBuilder {
	
	public TaskCategory buildNewTaskCategoryFromJson(final TaskCategoryJson taskCategoryJson);

	public TaskCategoryJson buildJsonFromTaskCategory(final TaskCategory taskCategory);
}
