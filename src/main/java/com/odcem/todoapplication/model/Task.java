package com.odcem.todoapplication.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



/**
 * @author Amit Kumar Gupta
 * The task model which represents a single task
 */

@Data 
@RequiredArgsConstructor
public class Task {

	final private int id;
	@NonNull private String title;
	@NonNull private String description;
	@NonNull private Status status;
	@NonNull private Date deadlineDate;
	// @Temporal(TemporalType.DATE)
	@NonNull private final Date creationDate;
	
	
	
	public static enum Status {
		DONE,
		PENDING
	}
	
}
