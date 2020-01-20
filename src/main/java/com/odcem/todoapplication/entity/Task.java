package com.odcem.todoapplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.odcem.todoapplication.enums.TaskStatusEnum;

/**
 * @author Amit Kumar Gupta
 * The task model which represents a single task
 */

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
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
	@Column(name = "status")
	private Byte status = TaskStatusEnum.PENDING.getId();
	
	/** 
	 * @see Timestamp maps to DATETIME in the MySql database.
	 */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deadline_date")
	private Date deadlineDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private TaskCategory taskCategory;

	public Task() {}
	
	public Task(String title, String description, Byte status, Date deadlineDate, Date creationDate, Boolean isDeleted,
			User user, TaskCategory taskCategory) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.deadlineDate = deadlineDate;
		this.creationDate = creationDate;
		this.isDeleted = isDeleted;
		this.user = user;
		this.taskCategory = taskCategory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TaskCategory getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(TaskCategory taskCategory) {
		this.taskCategory = taskCategory;
	}
	
	
}