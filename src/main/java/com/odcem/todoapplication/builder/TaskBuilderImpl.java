package com.odcem.todoapplication.builder;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odcem.todoapplication.dtos.TaskDto;
import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.enums.TaskStatusEnum;
import com.odcem.todoapplication.json.TaskJson;
import com.odcem.todoapplication.repository.TaskCategoryJpaRepository;
import com.odcem.todoapplication.repository.UserRepository;

/**
 * 
 * @author amitkumargupta
 *
 */

@Service
public class TaskBuilderImpl implements TaskBuilder{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskCategoryJpaRepository taskCategoryRepository;
	
	/**
	 * @see <b>When converting from Json to Task entity, the is deleted option is set to false by default.</b>
	 */
	@Override
	public Task buildNewTaskfromJson(final TaskJson taskJson) {
		
		// TODO: Learn and use configurable mapper here
		Date deadLineDate = null;
		if (!(taskJson.getDeadlineEpochDate() == null)) {
			if (! (taskJson.getDeadlineEpochDate().trim().isEmpty())) {
	 			deadLineDate = new Date(Long.parseLong(taskJson.getDeadlineEpochDate()));
			}
		}
		
		TaskCategory taskCat = null;
		if (taskJson.getCategoryId() != null) {
			taskCat = taskCategoryRepository.findTaskCategoryById(taskJson.getCategoryId(), false);
		}
		
		Task task = new Task(
				taskJson.getTitle(),
				taskJson.getDescription(),
				(byte) 0,
				deadLineDate,
				new Date(Long.parseLong(taskJson.getCreatedEpochDate())),				
				false,
				userRepository.getUserById(taskJson.getUserId()),
				taskCat
				);
				
		return task;
	}

	@Override
	public TaskDto buildTaskDtoFromTask(final Task task) {

		TaskDto taskDto = new TaskDto();
		taskDto.setId(task.getId());
		taskDto.setTitle(task.getTitle());
		taskDto.setDescription(task.getDescription());
		taskDto.setStatus(TaskStatusEnum.getEnumAsString(TaskStatusEnum.getEnumByValueByte(task.getStatus())));
		
		/**
		 * @see The epoch date is stored till seconds precision, hence it is divided by 1000.
		 */
		if (! (task.getDeadlineDate() == null)) {
			taskDto.setDeadlineEpochDate(String.valueOf(task.getDeadlineDate().getTime()));
		}			
		taskDto.setCreatedEpochDate(String.valueOf(task.getCreationDate().getTime()));
		taskDto.setUserId(task.getUser().getId());
		if (!(task.getTaskCategory() == null))
			if (!(task.getTaskCategory().getId() == null))
				taskDto.setCategoryId(task.getTaskCategory().getId());
		
		return taskDto;
	}

	@Override
	public TaskJson buildTaskJsonFromTask(final Task task) {
		
		TaskJson taskJson = new TaskJson();
		taskJson.setId(task.getId());		
		taskJson.setTitle(task.getTitle());
		
		if (task.getDescription() != null) {
			taskJson.setDescription(task.getDescription());
		}
		
		taskJson.setStatus(TaskStatusEnum.getEnumAsString(TaskStatusEnum.getEnumByValueByte(task.getStatus())));		
		/**
		 * @see The epoch date is stored till seconds precision, hence it is divided by 1000.
		 */
		if (! (task.getDeadlineDate() == null)) {
			taskJson.setDeadlineEpochDate(String.valueOf(task.getDeadlineDate().getTime()));
		}			
		taskJson.setCreatedEpochDate(String.valueOf(task.getCreationDate().getTime()));
		taskJson.setUserId(task.getUser().getId());
		if (!(task.getTaskCategory() == null))
			if (!(task.getTaskCategory().getId() == null))
				taskJson.setCategoryId(task.getTaskCategory().getId());
		
		return taskJson;
	}

	@Override
	public Task updateTaskFromJson(final TaskJson taskJson, final Task task) {
		
		if (taskJson.getTitle() != null) {
			task.setTitle(taskJson.getTitle());
		}
		
		if (taskJson.getDescription() != null) {			
			task.setDescription(taskJson.getDescription());
		}
		
		if (taskJson.getStatus() != null) {			
			task.setStatus(TaskStatusEnum.getTaskStatusByteFromString(taskJson.getStatus()));
		}
		
		if (taskJson.getDeadlineEpochDate() != null) {			
			task.setDeadlineDate(new Date(Long.parseLong(taskJson.getCreatedEpochDate())));
		}
		return task;
	}
	
	
}
