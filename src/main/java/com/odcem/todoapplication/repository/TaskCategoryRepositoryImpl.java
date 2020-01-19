package com.odcem.todoapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;

public class TaskCategoryRepositoryImpl implements TaskCategoryRepository {

	@Autowired
	private TaskCategoryJpaRepository taskCategoryJpaRepository;
}
