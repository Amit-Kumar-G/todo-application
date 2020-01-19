package com.odcem.todoapplication.exception;

public class TaskCategoryValidationException extends ApplicationException {

	private static final long serialVersionUID = 1L;
	
	public TaskCategoryValidationException() {}

	  /**
	   * @param message
	   */
	  public TaskCategoryValidationException(String message) {
	    super(message);
	  }

	  /**
	   * @param cause
	   */
	  public TaskCategoryValidationException(Throwable cause) {
	    super(cause);
	  }
}
