package com.odcem.todoapplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.odcem.todoapplication.enums.TaskStatusEnum;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Amit Kumar Gupta
 * The task model which represents a single task
 */

@Entity
@Table(name = "task")
@Data 
@NoArgsConstructor
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NonNull 
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;

	/**
	 * @see Byte values and status:
	 * 		0: Pending
	 * 		1: In progress
	 * 		2: Completed
	 */
	@NonNull
	@Column(name = "status")
	private Byte status = TaskStatusEnum.PENDING.getId();
	
	/** 
	 * @see Timestamp maps to DATETIME in the MySql database.
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deadline_date")
	private Date deadlineDate;

	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", updatable=false, insertable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", updatable=false, insertable=false)
	private TaskCategory taskCategory;
}