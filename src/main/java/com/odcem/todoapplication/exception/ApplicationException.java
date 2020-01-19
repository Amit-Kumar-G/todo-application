package com.odcem.todoapplication.exception;

import lombok.Getter;
import lombok.Setter;

public class ApplicationException extends RuntimeException {
	
	@Getter
	@Setter
	private String uiMessage;
	
	@Getter
	private static final long serialVersionUID = 1L;
	
	public ApplicationException() {}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message, String uiMessage) {
	  super(message);
	  this.uiMessage = uiMessage;
  }
}
