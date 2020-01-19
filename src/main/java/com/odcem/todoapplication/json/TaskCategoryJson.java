package com.odcem.todoapplication.json;

import java.util.List;

import lombok.Data;

@Data
public class TaskCategoryJson {
	
	private Integer id;
	
	private String name;
	
	private Integer userId;
	
	private List<TaskJson> tasks;
}
