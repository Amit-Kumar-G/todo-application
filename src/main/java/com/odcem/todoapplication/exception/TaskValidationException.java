package com.odcem.todoapplication.exception;

public class TaskValidationException extends ApplicationException {
	
	private static final long serialVersionUID = 1L;
	
	public TaskValidationException() {}

	  /**
	   * @param message
	   */
	  public TaskValidationException(String message) {
	    super(message);
	  }

	  /**
	   * @param cause
	   */
	  public TaskValidationException(Throwable cause) {
	    super(cause);
	  }
}
