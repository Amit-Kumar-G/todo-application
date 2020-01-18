package com.odcem.todoapplication.dtos;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {
	
	private Integer id;
	private String name;
	private String email;
	
	/**
	 * List of task id's
	 * Can be used to send an array of task ID's that the user wishes to add to the task when the category is created.
	 * @see the json array must be named <b>task_ids</b> when created.
	 */
	private List<Integer> task_ids;
}
