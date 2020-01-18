package com.odcem.todoapplication.dtos;

import lombok.Data;

@Data
public class TaskDto {
	
	private Integer id;
	private String title;
	private String description;
	private String status;
	private String deadlineEpochDate;
	private String createdEpochDate;
	private Integer userId;
	private Integer categoryId;
}
