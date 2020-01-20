package com.odcem.todoapplication.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.odcem.todoapplication.entity.TaskCategory;
import com.odcem.todoapplication.entity.User;

@Repository
public interface TaskCategoryJpaRepository<T extends TaskCategory, ID extends Integer> extends JpaRepository<T, ID> {

	@Override
	@Query("select u from TaskCategory u where u.isDeleted=false")
	public List<T> findAll();

	@Query("select u from TaskCategory u where u.id = :id and u.isDeleted = :isDeleted")
	public TaskCategory findTaskCategoryById(@Param("id") Integer id, @Param("isDeleted") Boolean isDeleted);
	
	@Transactional
	@Modifying
	@Query("update TaskCategory u set u.isDeleted = true where u.id = :id")
	public Integer softDeleteTaskCategoryById(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("update TaskCategory u set u.isDeleted = false where u.id = :id")
	public void retriveSoftDeletedTaskCategoryById(@Param("id") Integer id);
}
