package com.odcem.todoapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.odcem.todoapplication.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from user u where u.name = :name", nativeQuery = true)
	List<User> findUserByName(@Param("name") String name);
}
