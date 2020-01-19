package com.odcem.todoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odcem.todoapplication.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
