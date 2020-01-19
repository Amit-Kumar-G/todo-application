package com.odcem.todoapplication.json;

import com.odcem.todoapplication.enums.TaskStatusEnum;
import com.odcem.todoapplication.utility.Utils;

import lombok.Data;

@Data
public class TaskJson {
	
	private Integer id;
	private String title;
	private String description;
	private String status;
	private String deadlineEpochDate;
	private String createdEpochDate;
	private Integer userId;
	private Integer categoryId;
	
	/**
	 * @see setStatus and setDescription
	 * @see The setters for String fields are set to empty string insted of null if not supplied.
	 * @param status
	 */
	
	public void setDefaultValues() {
		
		this.createdEpochDate = Utils.getCurrentTimeInEpochString();
		
		if(status == null) {
			this.status = TaskStatusEnum.getEnumAsString(TaskStatusEnum.PENDING);
		}

		if (description == null) {
			this.description = "";
		}
			
		if (deadlineEpochDate == null) {
			this.deadlineEpochDate = "";
		}			
	}
	
	
//	/*
//	 * TODO: BUG: THESE SETTERS ARE NOT CALLED !!
//	 */
//	
//
//	public void setCreatedEpochDate(String createdEpochDate) {		
//		this.createdEpochDate = Utils.getCurrentTimeInEpochString();
//	}
//	
//	public void setStatus(String status) {
//
//		if(status == null) {
//			this.status = TaskStatusEnum.getEnumAsString(TaskStatusEnum.PENDING);
//		}
//		this.status = status;
//	}
//
//	public void setDescription(String description) {
//
//		if (description == null) {
//			this.description = "";
//		}
//		this.description = description;
//	}
//
//	public void setDeadlineEpochDate(String deadlineEpochDate) {
//		
//		if (deadlineEpochDate == null) {
//			this.deadlineEpochDate = "";
//		}
//		
//		this.deadlineEpochDate = deadlineEpochDate;
//	}
	
	
	
}
