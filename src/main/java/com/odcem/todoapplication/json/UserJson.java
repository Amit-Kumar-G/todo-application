package com.odcem.todoapplication.json;

import java.util.List;

import lombok.Data;

@Data
public class UserJson {
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	private List<TaskJson> taskJsonList;
}
