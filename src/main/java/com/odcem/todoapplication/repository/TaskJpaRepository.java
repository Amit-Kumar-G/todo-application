package com.odcem.todoapplication.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.Task;
import com.odcem.todoapplication.entity.User;

/**
 * Extended repository, can add additional functionality in the future.
 * @author amitkumargupta
 *
 */
@Repository
public interface TaskJpaRepository<T extends Task, ID extends Integer> extends JpaRepository<T, ID> {
	
	@Override
	@Query("select u from Task u where u.isDeleted=false")
	public List<T> findAll();

	@Query("select u from Task u where u.id = :id and u.isDeleted = :isDeleted")
	public Task findTaskById(@Param("id") Integer id, @Param("isDeleted") Boolean isDeleted);
	
	@Transactional
	@Modifying
	@Query("update Task u set u.isDeleted = true where u.id = :id")
	public Integer softDeleteTaskById(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("update Task u set u.isDeleted = false where u.id = :id")
	public void retriveSoftDeletedTaskById(@Param("id") Integer id);
}
