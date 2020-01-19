package com.odcem.todoapplication.exception;

public class UserValidationException extends ApplicationException {
	
	private static final long serialVersionUID = 1L;
	
	public UserValidationException() {}

	/**
	 * @param message
	 */
	public UserValidationException(String message) {
		super(message);
	}
	 
	/**
	 * @param cause
	 */
	public UserValidationException(Throwable cause) {
		super(cause);
	}
}
