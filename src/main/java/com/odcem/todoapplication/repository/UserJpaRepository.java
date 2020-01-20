package com.odcem.todoapplication.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odcem.todoapplication.entity.User;

public interface UserJpaRepository<T extends User, ID extends Integer> extends JpaRepository<T, ID> {

	@Query(value = "select * from user u where u.name = :name", nativeQuery = true)
	List<User> findUserByName(@Param("name") String name);

	@Override
	@Query("select u from User u where u.isDeleted=false")
	public List<T> findAll();

	@Query("select u from User u where u.id = :id and u.isDeleted = :isDeleted")
	public User findUserById(@Param("id") Integer id, @Param("isDeleted") Boolean isDeleted);
	
	@Query("select COUNT(t) from Task t WHERE t.user = :user")
	public Integer getNumberOfUserTasks(@Param("user") User user);
	
	@Query("select COUNT(t) from TaskCategory t WHERE t.user = :user")
	public Integer getNumberOfUserTaskCategories(@Param("user") User user);
	
	@Transactional
	@Modifying
	@Query("update User u set u.isDeleted = true where u.id = :id")
	public Integer softDeleteUserById(@Param("id") Integer id);
	
	@Transactional
	@Modifying
	@Query("update User u set u.isDeleted = false where u.id = :id")
	public void retriveSoftDeletedUserById(@Param("id") Integer id);
}
