package com.odcem.todoapplication.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NonNull
	@Column(name = "name")
	private String name;
	
	@NonNull
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	/*
	 * TODO: Ask how to fetch when FetchType is lazy.
	 * TODO: Ask if cascade is required on mysql tables.
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Task> tasks;
}
