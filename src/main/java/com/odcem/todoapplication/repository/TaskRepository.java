package com.odcem.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.model.Task;

/**
 * Extended repository, can add additional functionality in the future.
 * @author amitkumargupta
 *
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{

}
