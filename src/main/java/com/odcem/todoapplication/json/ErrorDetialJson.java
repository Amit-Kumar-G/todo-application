package com.odcem.todoapplication.json;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author amitkumargupta
 */

@Data
@AllArgsConstructor
public class ErrorDetialJson {
	
	private String errorSubCode;
	private String errorDescription;
	private String message;
	
	/**
	 * @see Used for errors without any description provided
	 */
	public ErrorDetialJson(String errorSubCode, String errorDescription) {
		this.errorSubCode = errorSubCode;
		this.errorDescription = errorDescription;
		this.message = "Contact support with the error code " + errorSubCode + ". Occoured at: " + (new Date());
	}
}
