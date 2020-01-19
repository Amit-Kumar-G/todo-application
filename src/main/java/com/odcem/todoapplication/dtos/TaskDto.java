package com.odcem.todoapplication.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {
	

	private Integer id;
	private String title;
	private String description;
	private String status;
	private String deadlineEpochDate;
	private String createdEpochDate;
	private Integer userId;
	private Integer categoryId;
	
	/*
	 * TODO: Add logic for is new dto in future, maybe helpful for null id cases.
	 */
}
