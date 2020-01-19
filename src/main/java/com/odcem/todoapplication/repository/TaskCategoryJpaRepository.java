package com.odcem.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.TaskCategory;

@Repository
public interface TaskCategoryJpaRepository extends JpaRepository<TaskCategory, Integer> {

}
